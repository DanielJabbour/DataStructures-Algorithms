class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        result.add(new ArrayList<String>());
        
        if(strs.length == 0)
            return result;
        
        result.get(0).add(strs[0]);
        
        if(strs.length == 1)
            return result;
        
        int flag = 1;
        
        for(int i=1;i<strs.length;i++){  
            for(int j=0;j<result.size();j++){
                if(isAnagram(strs[i], result.get(j).get(0))){
                    result.get(j).add(strs[i]);
                    flag = 0;
                }
            }
            if(flag == 1){
                result.add(new ArrayList<String>());
                result.get(result.size()-1).add(strs[i]);
            }
            flag = 1;
        }
        
        return result;
    }
    
    private boolean isAnagram(String s1, String s2){
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        if(s1.length() != s2.length())
            return false;
        
        //Add char to hmap
        for(int i=0;i<s1.length();i++){
            Integer c = hmap.get(s1.charAt(i));
            if(c == null)
                hmap.put(s1.charAt(i), 1);
            else
                hmap.put(s1.charAt(i), ++c);
        }
        
        for(int i=0;i<s2.length();i++){
            Integer c = hmap.get(s2.charAt(i));
            if(c == null)
                return false;
            else{
                c = c - 1;
                if(c == 0)
                    hmap.remove(s2.charAt(i));
                else
                    hmap.put(s2.charAt(i), c);
            }
        }
        
        if(hmap.isEmpty())
            return true;
        else
            return false;
    }
}

//Better
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0)
            return new ArrayList();
        
        Map<String, List> hmap = new HashMap<String, List>();
        
        //Letter count
        int[] count = new int[26];
        
        for(String s : strs){
            
            //Fill current array with 0s so we can access elements
            Arrays.fill(count, 0);
            
            //Increment each index appropriately
            for(char c : s.toCharArray())
                count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            
            String key = sb.toString();
            if(!hmap.containsKey(key))
                hmap.put(key, new ArrayList());
            
            //Retrieve anagram corresponding to key and add to it's list the current anagram
            hmap.get(key).add(s);
            
        }
        
        //return nested array representation of hmap, where each value from key is an array of anagrams
        return new ArrayList(hmap.values());
         
    }
}

