import java.util.Stack;

class Solution {
    public String toHex(int num) {
        Stack<Integer> stack = new Stack<>();
        while(num!=0)
        {
            stack.add(num%2);
            num=num/2;
        }
        while(stack.size()%4!=0)
        {
            stack.add(0);
        }
        int[] cstr = new int[stack.size()];
        int size = stack.size();
        for(int i=0;i<size;i++)
        {
            cstr[i] = stack.pop() - '0';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<cstr.length/4;i++)
        {
            int sum =0;
            for(int j=3;j>=0;j--)
            {
                sum+=Math.pow(2,j)*cstr[i*4+j];
            }
            if(sum<10)
            {
                stringBuilder.append(sum);
            }
            else
            {
                stringBuilder.append((char)(sum-10+'a'));
            }
        }
        return stringBuilder.toString();
    }
}