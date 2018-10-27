	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
public static int height(Node root) {
        // Write your code here.
      int max;
      //Return of greatest between left and right
      if(root == null)
          return -1;
      else
          max = height(root.left) > height(root.right) ? height(root.left) + 1 : height(root.right) + 1;
      return max;

}