/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int val = 0;
        
        if(root.left != null)
            val += rob(root.left.left) + rob(root.left.right);
        
        if(root.right != null)
            val += rob(root.right.right) + rob(root.right.left);
        
        return Math.max(root.val + val, rob(root.right) + rob(root.left));
        
    }
}

//Better with memoization
class Solution {
    public int rob(TreeNode root) {
        
        Map<TreeNode, Integer> memo = new HashMap<TreeNode, Integer>();
        
        return rob(root, memo);
        
    }
    
    private int rob(TreeNode root, Map<TreeNode, Integer> memo){
        if(root == null)
            return 0;
        
        if(memo.get(root) != null)
            return memo.get(root);
        
        int val = 0;
        
        if(root.left != null)
            val += rob(root.left.left, memo) + rob(root.left.right, memo);
        
        if(root.right != null)
            val += rob(root.right.right, memo) + rob(root.right.left, memo);
        
        val = Math.max(root.val + val, rob(root.right, memo) + rob(root.left, memo));
        memo.put(root, val);
        
        return val;
    }
}