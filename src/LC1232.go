package main

func checkStraightLine(coordinates [][]int) bool {
	if len(coordinates) <= 2 {
		return true
	}
	x1 := coordinates[0][0]
	x2 := coordinates[1][0]
	y1 := coordinates[0][1]
	y2 := coordinates[1][1]

	a := x1 - x2
	b := -y1 * (x1 - x2)
	c := y1 - y2
	d := -x1 * (y1 - y2)

	for i := 2; i < len(coordinates); i++ {
		x := coordinates[i][0]
		y := coordinates[i][1]
		if a*y+b != c*x+d {
			return false
		}
	}
	return true
}
