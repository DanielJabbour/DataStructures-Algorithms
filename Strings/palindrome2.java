class Solution {
    public boolean validPalindrome(String s) {
                
        int i = 0;
        int j = s.length() - 1;
        
        while(i<j){
            //Substring is exclusive at end index
            if(s.charAt(i) != s.charAt(j))
                return subPalindrome(s.substring(i+1, j+1)) || subPalindrome(s.substring(i, j));
            else{
                i++;
                j--;
            }
        }
        
        return true;
        
    }
    
    public boolean subPalindrome(String sub){
        int i = 0;
        int j = sub.length() - 1;
        
        while(i<j){
            if(sub.charAt(i) != sub.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        
        return true;
    }
}