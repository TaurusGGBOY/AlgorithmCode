package main

func isOneBitCharacter(bits []int) bool {
	//1111
	i := 0
	for i < len(bits)-1 {
		if bits[i] == 1 {
			i++
		}
		i++
	}
	return i == len(bits)-1 && bits[len(bits)-1] == 0
}
