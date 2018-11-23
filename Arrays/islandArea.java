class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                max = Math.max(maxAreaOfIsland(grid, i, j, Integer.MIN_VALUE),max);
            }
        }
        
        return max;
    }
    
    private int maxAreaOfIsland(int[][] grid, int i, int j, int global){
        
        //Out of bounds
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
            return 0;
        
        //Already visited
        if(grid[i][j] == -1)
            return 0;
        
        //Not part of island
        else if(grid[i][j] == 0){
            grid[i][j] = -1;
            return 0;
        }
        
        //encountered a 1
        else{
            
            //Mark as visited
            grid[i][j] = -1;
            
            //Define bounds
            int right = j + 1;
            int left = j - 1;
            int up = i - 1;
            int down = i + 1;
            
            int localIsland = maxAreaOfIsland(grid, i, right, global) + maxAreaOfIsland(grid, i, left, global) + maxAreaOfIsland(grid, up, j, global) + maxAreaOfIsland(grid, down, j, global) + 1;
            
            if(localIsland > global)
                global = localIsland;
            
            return global;
            
        }
        
    }
}