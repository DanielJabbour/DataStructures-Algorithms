class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int flag = 0;
        int lower = 0;
        int localMax;
        
        for(int i=0;i<seats.length;i++){
            
            //First 1
            if(seats[i] == 1 && flag == 0){
                lower = i;
                flag = 1;
            }
            
            else if(seats[i] == 1 && flag == 1){
                localMax = (i - lower)/2;
                if(localMax > max)
                    max = localMax;
                lower = i;
            }
            
        }
                
        //Forward pass
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 1){
                max = Math.max(max, i);
                break;
            }
        }
        
        //Backward pass
        for(int i=seats.length-1;i>=0;i--){
            if(seats[i] == 1){
                max = Math.max(max, seats.length - 1 - i);
                break;
            }
        }
        
        return max;
    }
}