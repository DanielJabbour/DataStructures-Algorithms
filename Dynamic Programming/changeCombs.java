import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long ways(int n, int[] coins, int index, HashMap<String, Long> memo) {
        int currentCoinSum = 0;
        long ways = 0;
        
        if(n == 0)
            return 1;
        if(index >= coins.length)
            return 0;
        
        //Keep a key of the current coin value and it's index
        String key = n + "-" + index;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        while(currentCoinSum <= n){
            int remaining = n - currentCoinSum;
            ways += ways(remaining, coins, index + 1, memo);
            currentCoinSum += coins[index];
        }
        
        //Store the current coin value and it's index with the number of ways
        memo.put(key, ways);
        
        return ways;
    }

}