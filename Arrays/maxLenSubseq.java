//Brute force
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
        
    }
    
    private int lengthOfLIS(int[] nums, int index, int prevVal){
        
        if(index == nums.length)
            return 0;
        
        int addVal = 0;
        int skipVal = 0;
        
        if(nums[index] > prevVal){
            addVal = 1 + lengthOfLIS(nums, index+1, nums[index]);
            skipVal = lengthOfLIS(nums, index+1, prevVal);
        }
        
        else if(nums[index] < prevVal){
            skipVal = lengthOfLIS(nums, index+1, prevVal);
        }
        
        int len = Math.max(addVal, skipVal);
        return len;
        
    }
}

//DP O(n^2) with 2 pointers
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] lengths = new int[nums.length];
        Arrays.fill(lengths, 1);
        
        if(nums.length == 0)
            return 0;
        
        //2 pointers to check each value, reset on meet
         
        for(int i = 1; i<nums.length;i++){
            for(int j=0;j<i;j++){
                
                if(nums[i] > nums[j])
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
            }
        }
        
        return findMax(lengths);
        
    }
    
    private int findMax(int[] arr){
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++)
            max = Math.max(max, arr[i]);
        
        return max;
    }
}