class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int prev1 = 0;
        int prev2 = 0;
        int current;
        
        for(int i=cost.length-1;i>=0;i--){
            current = cost[i] + minVal(prev1, prev2);
            
            //Our previous 2 steps ago is now the previous 1 step ago
            prev2 = prev1;
            
            //For next iteration, our previous 1-step is equal to the value just computed
            prev1 = current;
        }
        
        //Return the path resulting in lower cost based on 1-step or 2-step start
        return minVal(prev1, prev2);
    }
    
    public int minVal(int a, int b){
        
        int minValue = a < b ? a : b;
        
        return minValue;
    }
}