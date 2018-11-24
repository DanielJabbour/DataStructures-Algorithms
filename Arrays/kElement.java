//With sorting
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        return nums[nums.length - k];
        
    }
}

//With Max heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        
        int result = 0;
        
        for(int i=0;i<nums.length;i++)
            maxPQ.add(nums[i]);
        
        for(int i=0;i<k;i++)
            result = maxPQ.poll();
        
        return result;
        
    }
}
