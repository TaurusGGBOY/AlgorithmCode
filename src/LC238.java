class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k = k * nums[i]; // ��ʱ����洢���ǳ�ȥ��ǰԪ����ߵ�Ԫ�س˻�
        }
        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= k; // kΪ�����ұߵĳ˻���
            k *= nums[i]; // ��ʱ���������ߵ� * �����ұߵġ�
        }
        return res;
    }
}
