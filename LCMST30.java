import java.util.Stack;

class MinStack {
	int[] stack;
	int point;
	/** initialize your data structure here. */
	public MinStack() {
		point=0;
		stack = new int[20001];
	}

	public void push(int x) {
		stack[point++]=x;
	}

	public void pop() {
		point--;
	}

	public int top() {
		return stack[point-1];
	}

	public int min() {
		int min=stack[0];
		for(int i=1;i<point;i++)
		{
			if(stack[i]<min)
				min=stack[i];
		}
		return min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */