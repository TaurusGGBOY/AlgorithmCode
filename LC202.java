class Solution {
    public boolean isHappy(int n) {

        while(true)
        {
            String nstr = String.valueOf(n);
            char[] nca = nstr.toCharArray();
            int nlen = nstr.length();
            int sum = 0;
            for(int i = 0; i<nlen;i++)
            {
                int temp = nca[i]-'0';
                sum+=temp*temp;
            }
            if(sum==1)
                return true;
            if(sum==4)
                return false;
            n=sum;
        }
    }
}