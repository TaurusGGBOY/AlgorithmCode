// ʧ��
class Solution {
    public boolean divisorGame(int N) {
        int count = 0;
        int flag = 0;
        if (N <= 1)
            return false;
        while (flag == 0) {
            for (int i = N - 1; i >= 0; i--) {

                if (i == 0) {
                    flag = 1;
                    break;
                }
                if (N % i == 0) {
                    count++;
                    N = N - i;
                    break;
                }

            }
        }
        if (count % 2 == 1)
            return true;
        return false;
    }
}