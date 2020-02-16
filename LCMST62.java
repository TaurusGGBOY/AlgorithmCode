import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int lastRemaining(int n, int m) {
		m%=n;
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			queue.add(i);
		}
		int times=1;
		while(queue.size()!=1)
		{
			int temp = queue.poll();
			if(times++%m!=0)
				queue.add(temp);
		}
		return queue.peek();
	}
}