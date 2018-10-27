class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        //Loop and hash everything
        for(int i=0;i<nums1.length;i++){
            
            Integer c = hmap.get(nums1[i]);
            
            if(c == null)
                hmap.put(nums1[i], 1);
            else
                hmap.put(nums1[i], ++c);
        }
        
        for(int i=0;i<nums2.length;i++){
            if(hmap.get(nums2[i]) != null){
                result.add(nums2[i]);
                hmap.remove(nums2[i]);
            }
        }
        
        int[] resultArr = new int[result.size()];
        for(int i=0;i<result.size();i++)
            resultArr[i] = result.get(i);
        
        
        return resultArr;
    }
}