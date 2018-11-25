class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length == 0 || nums == null)
            return result;
        
        //Sort to allow for pointer traversal appropriately
        Arrays.sort(nums);
         
        for(int i=0;i<nums.length;i++){
            
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                
                int tripletSum = nums[i] + nums[left] + nums[right];
                
                if(tripletSum == 0){
                    List<Integer> set = new ArrayList<>();
                    
                    set.add(nums[i]);
                    set.add(nums[left]);
                    set.add(nums[right]);
                    
                    result.add(set);
                    
                    //Move away from all similar numbers
                    while(right-1 > left && nums[right] == nums[right-1])
                        right--;
                    while(left+1 < right && nums[left] == nums[left+1])
                        left++;
                    
                    //Increment to examine new b and c solution space using a
                    left++;
                    right--;
                }
                
                //Array is sorted, so we can move closer to the sum accordingly
                else if(tripletSum < 0)
                    left++;
                else
                    right--;
            }
            
            //Move away from i duplicates
            while(i + 1 < nums.length && nums[i] == nums[i+1])
                i++;
            
        }
        
        return result;
        
    }
}