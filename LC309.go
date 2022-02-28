package main

func maxProfit(prices []int) int {
	dp := make([][3]int, len(prices)+7)
	// dp[i][0] =
	// dp[i][1] =
	// dp[i][2]
	dp[0][0] = -prices[0]
	for i := 1; i < len(prices); i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][2]-prices[i])
		dp[i][1] = dp[i-1][0] + prices[i]
		dp[i][2] = max(dp[i-1][1], dp[i-1][2])
	}
	return max(dp[len(prices)-1][1], dp[len(prices)-1][2])
}

func max(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
