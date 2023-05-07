int maximum(int a,int b){
        long along=(long)a;
        long blong=(long)b;
        int k=((along-blong)>>63)&1; // 得到a-b的符号位
        return b*k+a*(k^1);
        }