class Solution {
    public int maxArea(int[] height) {
        
        int i = 0;
        int j = height.length - 1;
        
        int local = 0;
        int global = Integer.MIN_VALUE;
        
        while(i < j){
            
            local = (j - i) * Math.min(height[i], height[j]);
            
            if(local > global)
                global = local;
            
            if(height[i] < height[j])
                i++;
            else if(height[i] > height[j])
                j--;
            else{
                i++;
                j--;
            }
        }
        
        return global;
        
    }
}