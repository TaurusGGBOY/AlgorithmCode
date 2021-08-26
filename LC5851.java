class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int[] res = new int[65536];
        for (String num : nums) {
            res[Integer.parseInt(num,2)]=1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                stringBuilder.append(Integer.toBinaryString(i));
                break;
            }
        }
//        System.out.println(stringBuilder.toString());

        while(stringBuilder.length()<nums[0].length()) {
            stringBuilder.insert(0, "0");
//            System.out.println(nums[0].length()+" "+stringBuilder.length()+" 插入0");
        }
        return stringBuilder.toString();
    }


}