package main

func fib(n int) int{
	res:=make([]int,31)
	res[0]=0
	res[1]=1
	for i:=2;i<=n;i++{
		res[i]=res[i-1]+res[i-2]
	}
	return res[n]
}