class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for(int i=0;i<nums.length;i++){
            
            Integer ind = hmap.get(nums[i]);
            
            if(ind == null)
                hmap.put(target - nums[i], i);
            
            else{
                result[0] = ind;
                result[1] = i;
                break;
            }            
        }
        
        return result;
    }
}