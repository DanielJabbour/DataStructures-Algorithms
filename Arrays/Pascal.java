class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        
        if(numRows == 0)
            return pascal;
        
        //Have to init a new arrayList
        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);
        
        for(int i=1;i<numRows;i++){
            //Define current row, and retrieve previous row
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = pascal.get(i-1);
            
            currRow.add(1);
            
            for(int j=1;j<i;j++)
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            
            currRow.add(1);
            pascal.add(currRow);
        }
        
        return pascal;
        
    }
}