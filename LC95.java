import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();

        return dfs(1,n);
    }

    List<TreeNode> dfs(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        // 为什么start>end要加个null 因为List<TreeNode>中的TreeNode才是节点的值，而不应该是整个List
        if(start>end)
        {
            list.add(null);
            return list;
        }
        // 后序构造所有以i为节点的子树 这样能保证是从底层开始构造
        // 由于严格遵循 start i end这样的结构 所以用不上dp[i][j]？ 其实能用上 可以用dp[i][j]存储 但是要深拷贝
        for(int i =start;i<=end;i++)
        {
            // 因为左子树都是小于自身的 所以可以这样写就是一个二叉搜索树
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i+1, end);
            // 对于底层而言，新建这个节点左右都是空
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left=l;
                    treeNode.right=r;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}