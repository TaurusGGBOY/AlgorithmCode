import java.util.LinkedList;
import java.util.Queue;
// ˼· n������ kill���ǵ�n%m��
// ����������������x �������x��˭
// �����ڶ��� ����x��y�϶����� ����˵����겻�� ֻ��x������ (0+m)%2
// Ϊʲô��(0+m)%2 ��Ϊ���һ�ֿ������ yȻ��������������m����λ ���ܵõ������ڶ���
// Ҳ����˵ (��һ�ֵ�λ��+m)%��һ�ֵĳ���=��һ�ֵ�λ��

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