static List<Integer> freqQuery(List<List<Integer>> queries) {
        
    int length = queries.size();
    
    //Hashmap for value : frequency
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    List<Integer> result = new ArrayList<Integer>();
            
    for(int i=0;i<length;i++){
        
        //If we come across a 1, hash the value
        if(queries.get(i).get(0) == 1){
            Integer c = hmap.get(queries.get(i).get(1));
            if(c==null)
                hmap.put(queries.get(i).get(1), 1);
            else
                hmap.put(queries.get(i).get(1), ++c);
        }
        
        //If we come across a 2, remove 1 count of the frequency
        else if(queries.get(i).get(0) == 2){
            Integer c = hmap.get(queries.get(i).get(1));
            if(c!=null){
                c = c - 1;
                if(c==0)
                    hmap.remove(queries.get(i).get(1));
                else
                    hmap.put(queries.get(i).get(1), c);
            }
        }
        
        else if(queries.get(i).get(0) == 3){
            
            if(hmap.containsValue(queries.get(i).get(1)))
                result.add(1);
            else
                result.add(0);
        }
    }
    return result;
}