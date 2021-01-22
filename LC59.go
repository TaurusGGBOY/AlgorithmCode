
package main

func generateMatrix(n int) [][]int {
	matrix := make([][]int,n)
	for index := range matrix {
		matrix[index] = make([]int,n)
	}
	states := [][]int{{0,1},{1,0},{0,-1},{-1,0}}
	start_pos := []int{0,0}
	len := n
	count:=1
	curr_pos := []int{0,0}
	for len>0{
		curr_pos[0]=start_pos[0]
		curr_pos[1]=start_pos[1]
		if len==1{
			matrix[curr_pos[0]][curr_pos[1]]=count
			break
		}
		for i:=0;i<(len-1)*4;i++ {
			// len=3 i=0 state=0 i=1  state=0 i=2 state=1 i=3
			//fmt.Printf("len=%d,i=%d,curr_pos=%d,%d\n",len,i,curr_pos[0],curr_pos[1])
			matrix[curr_pos[0]][curr_pos[1]]=i+count
			state := states[i/(len-1)]
			curr_pos[0]+=state[0]
			curr_pos[1]+=state[1]
		}
		count+=4*(len-1)
		start_pos[0]++
		start_pos[1]++
		len-=2
	}
	return matrix
}