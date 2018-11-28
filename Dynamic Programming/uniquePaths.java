class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] memo = new int[m+1][n+1];
        
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i], -1);
        
        return uniquePaths(m, n, 1, 1, memo);
        
    }
    
    public int uniquePaths(int m, int n, int i, int j, int[][] memo){
        
        if(i > m || j > n)
            return 0;
        else if(i==m && j==n)
            return 1;
        else if(memo[i][j] != -1)
            return memo[i][j];
        
        else{
            memo[i][j] = uniquePaths(m,n,i+1,j, memo) + uniquePaths(m,n,i,j+1, memo);
            return memo[i][j];
        }
        
    }
}