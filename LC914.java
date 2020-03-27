import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < deck.length; i++) {
      map.merge(deck[i], 1, (oldval, newval) -> oldval + newval);
    }
    int x = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (x == 0) x = entry.getValue();
      x = maxCommonDivisor(x, entry.getValue());
    }
    return x > 1;
  }

  public static int maxCommonDivisor(int m, int n) {
    if (m < n) { // 保证m>n,若m<n,则进行数据交换
      int temp = m;
      m = n;
      n = temp;
    }
    if (m % n == 0) { // 若余数为0,返回最大公约数
      return n;
    } else { // 否则,进行递归,把n赋给m,把余数赋给n
      return maxCommonDivisor(n, m % n);
    }
  }
}
