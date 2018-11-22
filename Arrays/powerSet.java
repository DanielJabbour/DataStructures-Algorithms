class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> powerSet = new ArrayList<>();
        
        powerSet.add(new ArrayList<>());
        
        for(int i=0;i<nums.length;i++){
        
            int size = powerSet.size();
            //get new set
            for(int j=0;j<size;j++){
                
                List<Integer> subset = new ArrayList<>(powerSet.get(j));
                subset.add(nums[i]);
                powerSet.add(subset);
            }
            
        }
        
        return powerSet;
        
    }
}