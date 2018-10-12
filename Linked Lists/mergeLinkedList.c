#include <stdio.h>
#include <stdlib.h>

struct ListNode {
      int val;
      struct ListNode *next;
 };

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2);

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    
    struct ListNode* mergedList = (struct ListNode*)malloc(sizeof(struct ListNode*));
        
    struct ListNode* mergedTrav = mergedList;
    struct ListNode* trav1 = l1;
    struct ListNode* trav2 = l2;
    
    mergedList->val = (trav1->val <= trav2->val) ? trav1->val : trav2->val;
    mergedList->next = NULL;
    
    //Check which one was first copied over
    if(trav1->val < trav2->val)
        trav1 = trav1->next;
    if(trav1->val == trav2->val){
        trav1 = trav1->next;
        trav2 = trav2->next;
    }
        
    if(trav1->val < trav2->val)
        trav2 = trav2->next;
    
    while(trav1->next != NULL && trav2->next != NULL){
        
        //Main
        if(trav1->val < trav2->val){            
            struct ListNode* new_node = (struct ListNode*)malloc(sizeof(struct ListNode*));
            
            new_node->val = trav1->val;
            new_node->next = NULL;
            
            mergedTrav->next = new_node;
            
            trav1 = trav1->next;
        }
        
        else if(trav1->val == trav2->val){
            struct ListNode* new_node1 = (struct ListNode*)malloc(sizeof(struct ListNode*));
            struct ListNode* new_node2 = (struct ListNode*)malloc(sizeof(struct ListNode*));

            new_node1->val = trav1->val;
            new_node2->val = trav2->val;
            
            //Can I link 2 nodes at once?
            new_node2->next = NULL;
            new_node1->next = new_node2;
            
            mergedTrav->next = new_node1;
            
            trav1 = trav1->next;
            trav2 = trav2->next;
        }
        
        else if(trav1->val > trav2->val){
            struct ListNode* new_node = (struct ListNode*)malloc(sizeof(struct ListNode*));
            
            new_node->val = trav2->val;
            new_node->next = NULL;
            
            mergedTrav->next = new_node;
            
            trav2 = trav2->next;
        }
        
    }// end while
    
    return mergedList;
    
}