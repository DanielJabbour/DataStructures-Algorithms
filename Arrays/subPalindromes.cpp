class Solution {
public:
    int countSubstrings(string s) {
        //Expand around center
        
        int count = 0;
        
        //First pass with palindrome of length 1 || >= 3
        for(int i=0;i<s.size();i++){
            for(int j=0; j+i<s.size() && i-j >= 0 ;j++){
                
                if(s[i+j] == s[i-j])
                    count++;
                else
                    break;    
            }
        }
        
        //Second pass with palindrome of length 2
        for(int i=0;i<s.size();i++){
            for(int j=0; j+i+1<s.size() && i-j >= 0 ;j++){
                
                if(s[i+j+1] == s[i-j])
                    count++;
                else
                    break;    
            }
        }
        
        return count;
    }
};