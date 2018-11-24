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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> process = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        
        next.add(root);
        
        while(!next.isEmpty()){
            
            level = new ArrayList();
            
            while(!next.isEmpty())
                process.add(next.remove());
            
            
            while(!process.isEmpty()){
                TreeNode node = process.remove();
                
                if(node.left != null)
                    next.add(node.left);
                if(node.right != null)
                    next.add(node.right);
                
                level.add(node.val);
            }
            
            result.add(level);
        }
        
        return result;
        
    }
}

//Cleaner
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
               
        if(root == null) return result;

        queue.add(root);
        
        while(!queue.isEmpty()){
            
            List<Integer> level = new ArrayList<>();
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            result.add(level);
        }
        
        return result;
        
    }
}