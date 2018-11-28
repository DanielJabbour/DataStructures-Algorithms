class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        permute(nums, perm, result);
                
        return result;
        
    }
    
    private void permute(int[] nums, List<Integer> perm, List<List<Integer>> result){
        
        if(perm.size() == nums.length){
            List<Integer> currPerm = new ArrayList<>();
            currPerm.addAll(perm);
            result.add(currPerm);
        }
        
        //For each element to permute. P(n) = [n] + P(n+1:size)
        for(int i=0;i<nums.length;i++){
            if(perm.contains(nums[i]))
                continue;
            
            perm.add(nums[i]);
            permute(nums, perm, result);
            perm.remove(perm.size() - 1);
        }
        
    }
    
}