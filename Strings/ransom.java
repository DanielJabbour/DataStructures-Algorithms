class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(int i=0;i<magazine.length();i++){
            Integer c = hmap.get(magazine.charAt(i));
            
            if(c == null)
                hmap.put(magazine.charAt(i), 1);
            else
                hmap.put(magazine.charAt(i),++c);
        }
        
        for(int i=0;i<ransomNote.length();i++){
            
            Integer c = hmap.get(ransomNote.charAt(i));
            
            if(c == null)
                return false;
            
            else{
                if(c == 1)
                    hmap.remove(ransomNote.charAt(i));
                else
                    hmap.put(ransomNote.charAt(i), --c);
            }
            
        }
        
        return true;
    }
}