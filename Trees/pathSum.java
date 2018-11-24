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
    public boolean hasPathSum(TreeNode root, int sum) {
       
        return hasPathSum(root, null, sum);
        
    }
    
    private boolean hasPathSum(TreeNode root, TreeNode parent, int sum) {
        
        if(root == null)
            return false;
        
        if(parent!=null)
            root.val = root.val + parent.val;
        
        if(root.val == sum && (root.left == null && root.right == null))
            return true;
        
        else
            return hasPathSum(root.left, root, sum) || hasPathSum(root.right, root, sum);
    }
}