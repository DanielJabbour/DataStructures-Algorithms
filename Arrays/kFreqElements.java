class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        if(nums.length == 1){
            List<Integer> result = new ArrayList<Integer>();
            result.add(nums[0]);
            return result;
        }
        
        //Add nums to map of num -> frequency
        for(int num : nums){  
            Integer c = hmap.get(num);
            if(c == null)
                hmap.put(num, 1);
            else
                hmap.put(num,++c);
        }
        
        //Can we do this with nested arrayList? 
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(Integer key : hmap.keySet()) {
            if(bucket[hmap.get(key)] == null)
                bucket[hmap.get(key)] = new ArrayList<Integer>();
            
            bucket[hmap.get(key)].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=bucket.length-1; i>=0 && result.size() < k; i--){
            if(bucket[i] != null)
                result.addAll(bucket[i]);
        }
        
        return result;
    }
}