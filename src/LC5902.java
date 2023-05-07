class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1;
        String[] split = s.split(" ");
        for (String s1 : split) {
            try {
                int temp = Integer.parseInt(s1);
                if (temp > prev) {
                    prev = temp;
                }else{
                    return false;
                }
            } catch (Exception e) {

            }
        }
        return true;
    }
}