class Solution {
    public int rob(int[] nums) {
        
        int[] memo = new int[nums.length+1];
        
        //Need to fill with -1 for initialization
        Arrays.fill(memo,-1);
        
        return rob(nums, 0, memo);
    }
    
    private int rob(int[] nums, int i, int[] memo){
        
        if(i >= nums.length)
            return 0;
        
        else if(memo[i] >= 0)
            return memo[i];
        
        else{
            int result = Math.max(nums[i] + rob(nums, i+2, memo), rob(nums, i+1, memo));
            memo[i] = result;
            return result;
        }
        
    }
    
}

//Then convert to this:
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        int[] memo = new int[nums.length+1];
        
        memo[0] = 0;
        memo[1] = nums[0];
        
        for(int i=1;i<nums.length;i++){
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        
        return memo[nums.length];
        
    }
    
}