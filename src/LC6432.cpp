#include <iostream>

namespace decimal_util {

class int128 {
public:
  // Constructors.
  int128() = default;
  constexpr int128(int v);                // NOLINT(runtime/explicit)
  constexpr int128(unsigned int v);       // NOLINT(runtime/explicit)
  constexpr int128(long v);               // NOLINT(runtime/int)
  constexpr int128(unsigned long v);      // NOLINT(runtime/int)
  constexpr int128(long long v);          // NOLINT(runtime/int)
  constexpr int128(unsigned long long v); // NOLINT(runtime/int)
  explicit int128(float v);
  explicit int128(double v);
  explicit int128(long double v);

  // Assignment operators.
  int128 &operator=(int v);
  int128 &operator=(unsigned int v);
  int128 &operator=(long v);               // NOLINT(runtime/int)
  int128 &operator=(unsigned long v);      // NOLINT(runtime/int)
  int128 &operator=(long long v);          // NOLINT(runtime/int)
  int128 &operator=(unsigned long long v); // NOLINT(runtime/int)

  // Comparison operators.
  bool operator==(const int128 &other) const;
  bool operator!=(const int128 &other) const;

  // Int128Low64()
  friend constexpr uint64_t Int128Low64(int128 v);

  // Int128High64()
  friend constexpr int64_t Int128High64(int128 v);

  // MakeInt128()
  friend constexpr int128 MakeInt128(int64_t high, uint64_t low);

  // Arithmetic operators.
  constexpr int128 operator-(int128 v);
  constexpr int128 operator+(int128 lhs, int128 rhs);
  constexpr int128 operator-(int128 lhs, int128 rhs);
  int128 operator*(int128 lhs, int128 rhs);
  int128 operator/(int128 lhs, int128 rhs);
  int128 operator%(int128 lhs, int128 rhs);

private:
  constexpr int128(int64_t high, uint64_t low);

private:
  uint64_t lo_;
  int64_t hi_;
};

// Constructors.
constexpr int128::int128(int v)
    : lo_{static_cast<uint64_t>(v)}, hi_{v < 0 ? ~int64_t{0} : 0} {}
constexpr int128::int128(long v) // NOLINT(runtime/int)
    : lo_{static_cast<uint64_t>(v)}, hi_{v < 0 ? ~int64_t{0} : 0} {}
constexpr int128::int128(long long v) // NOLINT(runtime/int)
    : lo_{static_cast<uint64_t>(v)}, hi_{v < 0 ? ~int64_t{0} : 0} {}

constexpr int128::int128(unsigned int v) : lo_{v}, hi_{0} {}
// NOLINTNEXTLINE(runtime/int)
constexpr int128::int128(unsigned long v) : lo_{v}, hi_{0} {}
// NOLINTNEXTLINE(runtime/int)
constexpr int128::int128(unsigned long long v) : lo_{v}, hi_{0} {}

// Assignment operators.
inline int128 &int128::operator=(int v) { return *this = int128(v); }

inline int128 &int128::operator=(unsigned int v) { return *this = int128(v); }

inline int128 &int128::operator=(long v) { // NOLINT(runtime/int)
  return *this = int128(v);
}

// NOLINTNEXTLINE(runtime/int)
inline int128 &int128::operator=(unsigned long v) { return *this = int128(v); }

// NOLINTNEXTLINE(runtime/int)
inline int128 &int128::operator=(long long v) { return *this = int128(v); }

// NOLINTNEXTLINE(runtime/int)
inline int128 &int128::operator=(unsigned long long v) {
  return *this = int128(v);
}

// Comparison operators.
constexpr bool operator==(int128 lhs, int128 rhs) {
  return (Int128Low64(lhs) == Int128Low64(rhs) &&
          Int128High64(lhs) == Int128High64(rhs));
}

constexpr bool operator!=(int128 lhs, int128 rhs) { return !(lhs == rhs); }

// Int128Low64()
constexpr uint64_t Int128Low64(int128 v) { return v.lo_; }

// Int128High64()
constexpr int64_t Int128High64(int128 v) { return v.hi_; }

// MakeInt128()
constexpr int128 MakeInt128(int64_t high, uint64_t low, ) {
  return int128(high, low);
}

// Arithmetic operators.
constexpr int128 operator-(int128 v) {
  return MakeInt128(~Int128High64(v) + (Int128Low64(v) == 0),
                    ~Int128Low64(v) + 1);
}

namespace int128_internal {
constexpr int128 SignedAddResult(int128 result, int128 lhs) {
  // check for carry
  return (Int128Low64(result) < Int128Low64(lhs))
             ? MakeInt128(Int128High64(result) + 1, Int128Low64(result))
             : result;
}
} // namespace int128_internal

constexpr int128 operator+(int128 lhs, int128 rhs) {
  return int128_internal::SignedAddResult(
      MakeInt128(Int128High64(lhs) + Int128High64(rhs),
                 Int128Low64(lhs) + Int128Low64(rhs)),
      lhs);
}

namespace int128_internal {
constexpr int128 SignedSubstructResult(int128 result, int128 lhs, int128 rhs) {
  // check for carry
  return (Int128Low64(lhs) < Int128Low64(rhs))
             ? MakeInt128(Int128High64(result) - 1, Int128Low64(result))
             : result;
}

// Casts from unsigned to signed while preserving the underlying binary
// representation.
constexpr int64_t BitCastToSigned(uint64_t v) {
  // Casting an unsigned integer to a signed integer of the same
  // width is implementation defined behavior if the source value would not fit
  // in the destination type. We step around it with a roundtrip bitwise not
  // operation to make sure this function remains constexpr. Clang, GCC, and
  // MSVC optimize this to a no-op on x86-64.
  return v & (uint64_t{1} << 63) ? ~static_cast<int64_t>(~v)
                                 : static_cast<int64_t>(v);
}
} // namespace int128_internal
constexpr int128 operator-(int128 lhs, int128 rhs) {
  return int128_internal::SignedSubstructResult(
      MakeInt128(Int128High64(lhs) - Int128High64(rhs),
                 Int128Low64(lhs) - Int128Low64(rhs)),
      lhs, rhs);
}

inline int128 operator*(int128 lhs, int128 rhs) {
  return MakeInt128(
      int128_internal::BitCastToSigned(Uint128High64(uint128(lhs) * rhs)),
      Uint128Low64(uint128(lhs) * rhs));
}

namespace {
inline void DivModImpl(uint128 dividend, uint128 divisor, uint128 *quotient_ret,
                       uint128 *remainder_ret) {
  assert(divisor != 0);

  if (divisor > dividend) {
    *quotient_ret = 0;
    *remainder_ret = dividend;
    return;
  }

  if (divisor == dividend) {
    *quotient_ret = 1;
    *remainder_ret = 0;
    return;
  }

  uint128 denominator = divisor;
  uint128 quotient = 0;

  // Left aligns the MSB of the denominator and the dividend.
  const int shift = Fls128(dividend) - Fls128(denominator);
  denominator <<= shift;

  // Uses shift-subtract algorithm to divide dividend by denominator. The
  // remainder will be left in dividend.
  for (int i = 0; i <= shift; ++i) {
    quotient <<= 1;
    if (dividend >= denominator) {
      dividend -= denominator;
      quotient |= 1;
    }
    denominator >>= 1;
  }

  *quotient_ret = quotient;
  *remainder_ret = dividend;
}

uint128 UnsignedAbsoluteValue(int128 v) {
  // Cast to uint128 before possibly negating because -Int128Min() is undefined.
  return Int128High64(v) < 0 ? -uint128(v) : uint128(v);
}

} // namespace

int128 operator/(int128 lhs, int128 rhs) {
  assert(lhs != Int128Min() || rhs != -1); // UB on two's complement.

  uint128 quotient = 0;
  uint128 remainder = 0;
  DivModImpl(UnsignedAbsoluteValue(lhs), UnsignedAbsoluteValue(rhs), &quotient,
             &remainder);
  if ((Int128High64(lhs) < 0) != (Int128High64(rhs) < 0))
    quotient = -quotient;
  return MakeInt128(int128_internal::BitCastToSigned(Uint128High64(quotient)),
                    Uint128Low64(quotient));
}

int128 operator%(int128 lhs, int128 rhs) {
  assert(lhs != Int128Min() || rhs != -1); // UB on two's complement.

  uint128 quotient = 0;
  uint128 remainder = 0;
  DivModImpl(UnsignedAbsoluteValue(lhs), UnsignedAbsoluteValue(rhs), &quotient,
             &remainder);
  if (Int128High64(lhs) < 0)
    remainder = -remainder;
  return MakeInt128(int128_internal::BitCastToSigned(Uint128High64(remainder)),
                    Uint128Low64(remainder));
}

constexpr int128::int128(int64_t high, uint64_t low)
    : lo_(low), hi_(high) {}

} // namespace decimal_util

// test
int main() {
  int128 a = MakeInt128(0x2, 0x1);
  int128 b = MakeInt128(0x4, 0x3);
  int128 c = a + b;
  std::cout << "a + b == int128(6, 4): " << (c == MakeInt128(0x6, 0x4))
            << std::endl;

  c = b - a;
  std::cout << "b - a == int128(2, 2): " << (c == MakeInt128(0x2, 0x2))
            << std::endl;

  c = a * b;
  std::cout << "a * b == int128(8, 14): " << (c == MakeInt128(0x8, 0x14))
            << std::endl;

  std::cout << "a * b == int128(8, 3): " << (c == MakeInt128(0x8, 0x3))
            << std::endl;

  a = 2;
  b = 10000L;
  int128 d = 20000;

  c = a * b;
  std::cout << "a * b == d " << (c == d) << std::endl;

  // TODO: add division test
}
