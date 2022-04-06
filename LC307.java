class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        tree = new int[nums.length * 4];
        this.nums = nums;
        build(0, 0, nums.length - 1);
    }

    void build(int index, int l, int r) {
        if(l == r){
            tree[index] = nums[l];
            return;
        }
        int m = l + (r - l) / 2;
        build(index * 2 + 1, l, m);
        build(index * 2 + 2, m + 1, r);
        tree[index] = tree[index * 2 + 1] + tree[index * 2 + 2];
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, nums.length - 1);
    }

    void change(int index, int val, int root, int l, int r) {
        if(l == r){
            tree[root] = val;
            return;
        }
        int m = l + (r - l) / 2;
        if (index <= m) change(index, val, root * 2 + 1, l, m);
        else change(index, val, root * 2 + 2, m + 1, r);
        tree[root] = tree[root * 2 + 1] + tree[root * 2 + 2];
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, nums.length - 1);
    }

    int range(int left, int right, int root, int l, int r) {
        if (left == l && right == r) {
            return tree[root];
        }
        int m = l + (r - l / 2);
        if(right <=m) return range(left, right, root * 2 + 1, l, r);
        else if(left > m) return range(left, right, root * 2 + 2, m+1, r);
        else return range(left, m, root * 2 + 1, l, m) + range(m + 1, right, root * 2 + 2, m + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */