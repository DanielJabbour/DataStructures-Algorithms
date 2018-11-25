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
    public boolean isValidBST(TreeNode root) {
        
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
        
    }
    
    public boolean isValidBST(TreeNode root, long upper, long lower){
        
        if(root == null)
            return true;
        
        if(root.val >= upper || root.val <= lower)
            return false;
        
        else
            return isValidBST(root.left, root.val, lower) && isValidBST(root.right, upper, root.val);
        
    }
}