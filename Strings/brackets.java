class Solution {
    public boolean isValid(String s) {
                
        Stack stack = new Stack();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            
            else if(!stack.isEmpty()){
                if(s.charAt(i) == ')' && (char)stack.peek() == '(')
                    stack.pop();
                else if(s.charAt(i) == ']' && (char)stack.peek() == '[')
                    stack.pop();
                else if(s.charAt(i) == '}' && (char)stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
            
            else
                return false;

        }
        
        return stack.isEmpty() ? true : false;
    }
}