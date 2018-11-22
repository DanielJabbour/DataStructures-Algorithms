class Solution {
    public int minPathSum(int[][] grid) {
        
        return minPathSum(grid, 0, 0, 0, Integer.MAX_VALUE);
        
    }
    
    private int minPathSum(int[][] grid, int r, int c, int loc, int glob){
        
        //Add current value
        loc += grid[r][c];
        
        //Check if we've already exceeded current min
        if(loc >= glob)
            return glob;
        
        int rightSubPath = Integer.MAX_VALUE;
        int downSubPath = Integer.MAX_VALUE;
        
        //If we've reached bottom right of grid, return current global min
        if(r == grid.length - 1 && c == grid[0].length - 1){
            
            if(loc < glob)
                glob = loc;
            
            return glob;
        }

        //Check if valid
        
        //Traverse right
        if(c + 1 < grid[0].length){
            int right = c + 1;
            rightSubPath = minPathSum(grid, r, right, loc, glob);
        }
        
        //Traverse down
        if(r + 1 < grid.length){
            int down = r + 1;
            downSubPath = minPathSum(grid, down, c, loc, glob);
        }
        
        return Math.min(rightSubPath, downSubPath);   
    }
}

//Better
class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        //Compute weights down column
        for(int i=1;i<col;i++)
            grid[0][i] += grid[0][i-1];
        
        //Compute weights down row
        for(int i=1;i<row;i++){
            grid[i][0] += grid[i-1][0];
        }
        
        //Compute weights diagonally and right
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[row-1][col-1];
    }
    
}