class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int localMax = nums[0];
        int globalMax = nums[0];
        
        for(int i=1;i<nums.size();i++){
            localMax = max(nums[i], nums[i] + localMax);
            if(localMax > globalMax)
                globalMax = localMax;
        }
        
        return globalMax;
    }
};