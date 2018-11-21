//O(nlogn) worst
class Solution {
    public int maximumProduct(int[] nums) {
        
        //Find the 3 maxes
        Arrays.sort(nums);
        
        return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3]);
        
    }
}

//Better, O(n)
class Solution {
    public int maximumProduct(int[] nums) {
        
        //Find min 1, min 2, max 1, max 2, and max 3
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            
            //Adjust mins
            if(nums[i] <= min1){
                min2 = min1;
                min1 = nums[i];
            } 
            else if (nums[i] <= min2){
                min2 = nums[i];
            }
            
            //Adjust maxes
            if(nums[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] >= max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] >= max3)
                max3 = nums[i];
            
        }
        
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}