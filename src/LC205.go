package main

func isIsomorphic(s string, t string) bool {
	s2t := map[byte]byte{}
	t2s := map[byte]byte{}

	for i := range s {
		x := s[i]
		y := t[i]
		// 说明map初始化值为？
		// map没初始化也可以获得值
		if s2t[x] > 0 && s2t[x] != y {
			return false
		}
		if t2s[y] > 0 && t2s[y] != x {
			return false
		}
		s2t[x] = y
		t2s[y] = x
	}
	return true
}
