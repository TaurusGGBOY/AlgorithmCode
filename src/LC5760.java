class Solution {
    public int minSwaps(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.toCharArray().length; i++) {
            count[s.charAt(i) - '0']++;
        }
        if (Math.abs(count[0] - count[1]) > 1) {
            return -1;
        }

        if (count[0] != count[1]) {
            StringBuilder stringBuilder = new StringBuilder();
            char temp = count[0] > count[1] ? '0' : '1';
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(temp);
                if (temp == '0') {
                    temp = '1';
                } else {
                    temp = '0';
                }
            }
            int res = 0;
            char[] chars = stringBuilder.toString().toCharArray();
            char[] schars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != schars[j]) {
                    for (int k = j + 1; k < schars.length; k += 2) {
                        if (schars[j] != schars[k]) {
                            swap(schars, j, k);
                            res++;
                            break;
                        }
                    }
                }
            }
            return res;
        }


        // count[0] == count[1]
        StringBuilder[] stringBuilder = new StringBuilder[2];
        stringBuilder[0] = new StringBuilder();
        stringBuilder[1] = new StringBuilder();
        char[] temp = {'0', '1'};
        int[] res = new int[2];
        for (int j = 0; j < 2; j++) {

            for (int i = 0; i < s.length(); i++) {
                stringBuilder[j].append(temp[j]);
                if (temp[j] == '0') {
                    temp[j] = '1';
                } else {
                    temp[j] = '0';
                }
            }
        }
//        System.out.println("one time");
//        System.out.println(stringBuilder[0].toString());
//        System.out.println(stringBuilder[1].toString());

        for (int i = 0; i < 2; i++) {
            char[] chars = stringBuilder[i].toString().toCharArray();
            char[] schars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != schars[j]) {
                    for (int k = j + 1; k < schars.length; k += 2) {
                        if (schars[j] != schars[k]) {
                            swap(schars, j, k);
                            res[i]++;
                            break;
                        }
                    }
                }
            }

        }
        return Math.min(res[0], res[1]);

        //"1100"
        //"0011"
        //"0101"

    }

    void swap(char[] chars, int src, int dst) {
        if (chars[src] == '1') {
            chars[src] = '0';
            chars[dst] = '1';
        } else {
            chars[src] = '1';
            chars[dst] = '0';
        }
    }
}