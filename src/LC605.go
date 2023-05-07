package main

func canPlaceFlowers(flowerbed []int, n int) bool {
	if n==0{
		return true
	}
	if n == 1 && len(flowerbed)==1&&flowerbed[0] == 0{
			return true
	}
	count := 0
	if flowerbed[0] == 0 && flowerbed[1] == 0 {
		flowerbed[0]=1
		count++
	}
	for i := 1; i < len(flowerbed)-1; i++ {
		if flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 {
			flowerbed[i] = 1
			count++
		}
		if count >=n{
			return true
		}
	}
	if flowerbed[len(flowerbed)-1] == 0 && flowerbed[len(flowerbed)-2] == 0 {
		count++
	}
	return count >= n
}
//[0,1,0]
//1
