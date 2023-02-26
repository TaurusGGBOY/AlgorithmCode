a = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

# 把因子的index映射到一个数y上
def factor(x):
    y = 0
    for i in range(len(a)):
        if x % a[i] == 0: # 如果有这个因子
            x //= a[i] # 除以这个因子
            y |= 1 << i # 并记录一下
        if x % a[i] == 0: # 如果还有说明因子是平方数 返回错误
            return -1
    return y


# 把30个数的因子都映射
f = [factor(i) for i in range(31)]

class Solution:
    def squareFreeSubsets(self, nums: List[int]) -> int:
        dp = [0] * 1024
        dp[0] = 1
        for x in nums:
            # 如果这个数的因子小于0 就说明抛弃
            if f[x] >= 0:
                # 否则 因为10个因子 一共有1024个组合 所以只要这个组合和你的因子分解组合没有一个数是相等的
                for i in range(1024):
                    if i & f[x] == 0:
                        #
                        dp[i | f[x]] += dp[i]
        return (sum(dp) - 1) % 1000000007
