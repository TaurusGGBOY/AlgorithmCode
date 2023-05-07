class Solution {
    public String thousandSeparator(int n) {
        String ns = String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        if(ns.length()<4)
            return ns;
        int first = ns.length()%3==0?3:ns.length()%3;
        stringBuilder.append(ns.substring(0, first));
        for(int i =first;i<ns.length();i+=3)
        {
            stringBuilder.append(".");
            stringBuilder.append(ns.substring(i, i + 3));

        }
        return stringBuilder.toString();
    }
}