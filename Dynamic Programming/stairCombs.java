//Recursive dp
class Solution {
    public int climbStairs(int n) {
        
        int[] memo = new int[n+1];
        return climbStairsMemo(n, memo);
        
    }

    public int climbStairsMemo(int n, int[] memo){
        
        //Base cases
        if(memo[n] > 0)
            return memo[n];
        
        else if(n == 2)
            return 2;
        else if(n == 1)
            return 1;
        else if(n == 0)
            return 0;
    
        else{
            memo[n] = climbStairs(n-2) + climbStairs(n-1);
            return memo[n];
        }
    }
}

//Better - O(n) iterative dp
class Solution {
    public int climbStairs(int n) {
        
        if (n == 1)
            return 1;
        
        int[] stairs = new int[n+1];
        stairs[0] = 0;
        stairs[1] = 1;
        stairs[2] = 2;
        
        for(int i=3;i<n+1;i++)
            stairs[i] = stairs[i-1] + stairs[i-2];
            
        return stairs[n];
        
    }
}

//This reduces to simply finding the fibonacci number, so hence we don't need to store array values
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) 
            return 1;
        
        int prev2 = 1;
        int prev1 = 2;
        
        for (int i = 3; i <= n; i++) {
            int next = prev2 + prev1;
            prev2 = prev1;
            prev1 = next;
        }
        
        return prev1;
    }
}
