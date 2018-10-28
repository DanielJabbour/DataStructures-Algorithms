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
    public List<Double> averageOfLevels(TreeNode root) {
     
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        
        nodeQ.add(root);
        
        while(!nodeQ.isEmpty()){
            Double sum = 0.0;
            Double count = 0.0;
            
            Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
            
            while(!nodeQ.isEmpty()){
                
                TreeNode temp = nodeQ.remove();
                sum += temp.val;
                count++;
                
                if(temp.left!=null)
                    tempQ.add(temp.left);
                if(temp.right!=null)
                    tempQ.add(temp.right);
                
            }
            
            nodeQ = tempQ;
            result.add(sum*1.0/count);
        }
        
        return result;
        
    }
}