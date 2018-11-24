class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0)
            return false;
        
        int i = 0;
        int j = matrix[0].length - 1;
        
        while(i<matrix.length && j>=0){
            
            if(matrix[i].length == 0)
                return false;
            
            int currentVal = matrix[i][j];
            
            if(target == currentVal)
                return true;
            else if(target < currentVal)
                j--;
                
            else
                i++;

        }
        
        return false;
    }
}