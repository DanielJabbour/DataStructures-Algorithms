class Solution {
    public int numSquares(int n) {
      
        int[] ps = new int[n+1];
        Arrays.fill(ps,Integer.MAX_VALUE);
        ps[0] = 0;
        
        if(n == 0)
            return 0;
        
        for(int i=1;i<=n;i++){
            
            int min = Integer.MAX_VALUE;
            int j = 1;
            
            while(i - j*j >= 0){
                min = Math.min(ps[i-j*j] + 1, min);
                j++;
            }
            
            ps[i] = min;
        }
        
        return ps[n];
        
    }
}