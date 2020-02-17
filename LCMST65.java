import java.util.Queue;

class Solution {
    public int add(int a, int b) {
        String astr = Integer.toBinaryString(a);
        String bstr = Integer.toBinaryString(b);
        if (astr.length() > bstr.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < astr.length() - bstr.length(); i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(astr);
            astr = stringBuilder.toString();
        }
        if (bstr.length() > astr.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bstr.length() - astr.length(); i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(bstr);
            bstr = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int c=0;
        for(int i=astr.length()-1;i>=0;i++)
		{

		}
		Queue
    }
}