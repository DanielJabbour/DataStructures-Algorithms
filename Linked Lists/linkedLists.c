#include <stdio.h>
#include <stdlib.h>

//Defining linked list node structure
typedef struct node {
    int data;
    struct node* next;
} node;

node* create(int val, node* next);
void add(int val, node* head);
void removeEnd(node* head);

int main() {
    
    node* head = create(0, NULL);

    removeEnd(head);
    
    node* temp = head;
    while(temp!=NULL){
        printf("%d\n", temp->data);
        temp = temp->next;
    }

}

//Create the node
node* create(int val, node* next) {

    //Allocate memory for new node
    node* new_node = (node*)malloc(sizeof(node*));

    if (new_node == NULL) {
        printf("Null Node Error. \n");
        exit(0);
    }

    //New node data points to val, and next to next node
    new_node->data = val;
    new_node->next = next;

    return new_node;
}

//Adds value to end of linked list
void add(int val, node* head) {

    node* temp = head;

    while(temp->next != NULL) {
        temp = temp->next;
    }

    node* new_node = create(val, NULL);
    temp->next = new_node;

}

//Removes end value
void removeEnd(node* head) {
    
    if (head->next == NULL){
        head = NULL;
        return;
    }

    node* temp = head;

    while(temp->next->next!=NULL){
        temp = temp->next;
    }

    temp->next = NULL;
}