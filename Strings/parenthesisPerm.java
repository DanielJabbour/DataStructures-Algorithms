class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<String>();
        String start = "";
        
        generateParenthesis(n, 0, 0, start, result);
        
        return result;
        
    }
    
    private void generateParenthesis(int n, int open, int close, String start, List<String> result){

        if(start.length() == 2*n){
            result.add(start);
            return;
        }
        
        if(open < n)
            generateParenthesis(n, open+1, close, start + "(", result);
        
        
        if(close < open)
            generateParenthesis(n, open, close+1, start + ")", result);
        
    }
}