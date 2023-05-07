package main

func minCostClimbingStairs(cost []int) int {
	if len(cost) <= 1 {
		return 0
	}
	if len(cost) == 2 {
		if cost[0] > cost[1] {
			return cost[1]
		} else {
			return cost[0]
		}
	}
	var dp [1000]int
	dp[0] = cost[0]
	dp[1] = cost[1]
	for i := 2; i < len(cost); i++ {
		if dp[i-2] > dp[i-1] {
			dp[i] = dp[i-1] + cost[i]
		} else {
			dp[i] = dp[i-2] + cost[i]
		}
	}
	if dp[len(cost)-1] > dp[len(cost)-2] {
		return dp[len(cost)-2]
	}
	return dp[len(cost)-1]

}
