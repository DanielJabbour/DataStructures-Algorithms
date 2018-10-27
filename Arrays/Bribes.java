static void minimumBribes(int[] q) {
        
    int bribes = 0;
    
    for(int i=q.length-1; i>=0; i--){
        if(q[i] - (i+1) > 2){
            System.out.println("Too chaotic");
            return;
        }
        for(int j = 0 >= q[i] - 2 ? 0:q[i] - 2; j<i; j++)
            if(q[j] > q[i])
                bribes++;
    }
    
    System.out.println(bribes);
}