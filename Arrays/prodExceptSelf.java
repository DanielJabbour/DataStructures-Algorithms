class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        
        result[0] = 1;
        int accum = 1;
        
        //Forward pass
        for(int i=1;i<nums.length;i++)
            result[i] = result[i-1] * nums[i-1];
        
        //Backward pass
        for(int i=nums.length-1;i>=0;i--){
            result[i] = accum * result[i];
            accum *= nums[i];
        }

        return result;
        
    }
}