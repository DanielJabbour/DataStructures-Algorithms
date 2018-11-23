class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        //First, convert strings to minutes
        
        int[] arr = new int[timePoints.size()];
        
        for(int i=0;i<timePoints.size();i++){
            
            //Convert string to integer

            //Get hours and mins
            String hours = timePoints.get(i).substring(0,2);
            String mins = timePoints.get(i).substring(3,5);
            
            int hours_int = Integer.valueOf(hours);
            int mins_int = Integer.valueOf(mins);
            
            int dist = hours_int*60 + mins_int;
            
            //Find minimum from both distances and append
            arr[i] = dist;
        }
        
        //Find both mins and subtract
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        int minDif = Integer.MAX_VALUE;
        
        for(int i=1;i<arr.length;i++){
            minDif = Math.min(arr[i] - arr[i-1], minDif);
        }
        
        int corner = arr[0] + (1440 - arr[arr.length-1]);
        
        
        return Math.min(minDif, corner);
            
    }
}