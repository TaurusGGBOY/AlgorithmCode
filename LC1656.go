package main

type OrderedStream struct {
	strs []string
	pointer int
}


func Constructor(n int) OrderedStream {
	stream := new(OrderedStream)
	stream.strs=make([]string,n+1)
	stream.pointer=1
	return *stream
}


func (this *OrderedStream) Insert(id int, value string) []string {
	this.strs[id]=value
	res := make([]string,0)
	for this.pointer<len(this.strs)&&this.strs[this.pointer]!=""{
		res = append(res, this.strs[this.pointer])
		this.pointer++
	}
	return res
}


/**
 * Your OrderedStream object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Insert(id,value);
 */