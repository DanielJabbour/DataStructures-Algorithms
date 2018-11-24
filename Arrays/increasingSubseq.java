class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        
        findSubsequences(nums, path, 0, result);
        return result;
    }
    
    public void findSubsequences(int[] nums, LinkedList<Integer> path, int index, List<List<Integer>> result){
        
        //Add current path to result array
        if(path.size() > 1)
            result.add(new LinkedList<Integer>(path));
        
        Set<Integer> memo = new HashSet<Integer>();
        
        //Iterate through all items
        for(int i=index;i<nums.length;i++){
            // init and continue condition

            if((path.size() == 0 || path.peekLast() <= nums[i]) && !memo.contains(nums[i])){
                path.add(nums[i]);
                memo.add(nums[i]);
                findSubsequences(nums, path, i+1, result);
                
                //Remove current element from set to determine remaining set without
                path.remove(path.size() - 1);
            }
        }
        
    }
}