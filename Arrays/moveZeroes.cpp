class Solution {
    public:
        void moveZeroes(vector<int>& nums) {
            int i = 0;
            int j = 1;
            
            while(j<nums.size()){
                
                int curr = nums[i];
                int next = nums[j];
                
                //Swap appropriately
                if(curr == 0 && next != 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j++;
                }
                
                else if(curr == 0 && next == 0)
                    j++;
                
                else if(curr != 0){
                    i++;
                    j++;
                }
            }
        }
    };