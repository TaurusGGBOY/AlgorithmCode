class Solution {
    public int waysToMakeFair(int[] nums) {
        int aheadOddSum = 0;
        int aheadEvenSum = 0;
        int tailOddSum = 0;
        int tailEvenSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                aheadEvenSum += nums[i];
            } else {
                aheadOddSum += nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
//            System.out.println(aheadEvenSum + " " + aheadOddSum + " " + tailOddSum + " " + tailEvenSum + " ");
            if (i % 2 == 0) {
                aheadEvenSum -= nums[i];
//                System.out.println(aheadEvenSum + " " + aheadOddSum + " " + tailOddSum + " " + tailEvenSum + " ");
                if (aheadEvenSum + tailEvenSum == aheadOddSum + tailOddSum)
                    count++;
                tailOddSum += nums[i];
            } else {
                aheadOddSum -= nums[i];
//                System.out.println(aheadEvenSum + " " + aheadOddSum + " " + tailOddSum + " " + tailEvenSum + " ");
                if (aheadEvenSum + tailEvenSum == aheadOddSum + tailOddSum)
                    count++;
                tailEvenSum += nums[i];
            }

//            System.out.println();
        }
        return count;
    }
}