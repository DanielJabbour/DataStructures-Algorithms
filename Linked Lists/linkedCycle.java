/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    
    if(head == null)
        return false;
    
    Node temp1 = head;
    Node temp2 = head.next;
    
    while(temp1!=null || temp2!=null){
        if(temp1 == temp2)
            return true;
        
        if(temp1.next == null || temp2.next == null)
            return false;
        
        temp1 = temp1.next;
        temp2 = temp2.next.next;
    }
    return false;
}