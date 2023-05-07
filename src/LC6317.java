class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ nums[i];
        }

        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (prefixXor[i] == 0) {
                ans++;
            }
            if (map.containsKey(prefixXor[i])) {
                ans += map.get(prefixXor[i]);
            }
            map.put(prefixXor[i], map.getOrDefault(prefixXor[i], 0) + 1);
        }
        return ans;
    }
}