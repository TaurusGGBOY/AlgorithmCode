class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        return match(haystack, needle, next);
    }

    int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        // 双指针法
        // 每一次是在求一个next数组的元素
        // i=0的时候 其实已经匹配了，就是0，所以不用管
        // j的回退：如果不相等，但是因为前面的一定是match的，所以回退到next[j-1]
        // 但是为什么会是回多次？不是回一次 因为一直在和i比较
        // 所以next应该是叫做匹配的前缀的下一个字符
        // 只有在两个char相等的时候才j++
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (needle.charAt(i) == needle.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }

    int match(String haystack, String needle, int[] next) {
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }
}