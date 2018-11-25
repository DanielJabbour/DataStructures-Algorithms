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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> process = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        
        if(root == null)
            return result;
        
        next.offer(root);
        
        while(!next.isEmpty()){
            
            //Transfer contents
            while(!next.isEmpty())
                process.offer(next.poll());
            
            while(process.size()!=1){
                TreeNode node = process.poll();
                if(node.left!=null) next.offer(node.left);
                if(node.right!=null) next.offer(node.right);
            }
            
            TreeNode rightNode = process.poll();
            if(rightNode.left!=null) next.offer(rightNode.left);
            if(rightNode.right!=null) next.offer(rightNode.right);
            
            result.add(rightNode.val);
        }
        
        return result;
        
    }
}