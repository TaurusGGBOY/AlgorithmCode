class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        if(num1.length()-num2.length()>0)
        {
            for(int i=0;i<Math.abs(num1.length()-num2.length());i++)
                stringBuilder2.append('0');
        }
        else
        {
            for(int i=0;i<Math.abs(num1.length()-num2.length());i++)
                stringBuilder1.append('0');
        }
        stringBuilder1.append(num1);
        stringBuilder2.append(num2);
        StringBuilder str = new StringBuilder();
        int inPos=0;
        for(int i=stringBuilder1.length()-1;i>=0;i--)
        {
            int sum = stringBuilder1.charAt(i)+stringBuilder2.charAt(i)-'0'-'0'+inPos;
            if(sum>=10)
            {
                inPos=1;
                sum-=10;
            }
            else
            {
                inPos=0;
            }
            str.append(sum);
        }
        if(inPos==1)
            str.append(1);
        str.reverse();
        return str.toString();
    }
}