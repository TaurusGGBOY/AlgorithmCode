package main

type ParkingSystem struct {
	parks []int
}


func Constructor(big int, medium int, small int) ParkingSystem {
	obj := new(ParkingSystem)
	obj.parks = make([]int,4)
	obj.parks[1] = big
	obj.parks[2] = medium
	obj.parks[3] = small
	return *obj
}

func (this *ParkingSystem) AddCar(carType int) bool {
	if this.parks[carType]>0{
		this.parks[carType]--
		return true
	}
	return false
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * obj := Constructor(big, medium, small);
 * param_1 := obj.AddCar(carType);
 */
