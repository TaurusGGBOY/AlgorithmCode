import java.util.LinkedList;
import java.util.Queue;
// 思路 n个数据 kill的是第n%m个
// 假设最后活下来的是x 不管这个x是谁
// 倒数第二轮 除了x的y肯定挂了 这个人的坐标不管 只管x的坐标 (0+m)%2
// 为什么是(0+m)%2 因为最后一轮可以填充 y然后将整个数组右移m个单位 就能得到倒数第二轮
// 也就是说 (这一轮的位置+m)%上一轮的长度=上一轮的位置

class Solution {
    public int lastRemaining(int n, int m) {
        return pos(0,n,m);

    }
    int pos(int times,int n,int m)
    {
        if(times==n)
            return 0;
        return (pos(times+1,n,m)+m)%(n-times);
    }
}