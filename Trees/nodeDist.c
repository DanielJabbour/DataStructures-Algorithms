#include <stdio.h>
#include <stdlib.h>

typedef struct treeNode {
    int val;
    struct treeNode* left;
    struct treeNode* right;
} treeNode;

treeNode* findLCA(treeNode* root, treeNode* p, treeNode* q);
int distance(treeNode* p, treeNode* q, int dist);
int lowestDist(treeNode* root, treeNode* p, treeNode* q);
treeNode* createNode(int val);
void printTree(treeNode* root);


int main(){

    treeNode* root = createNode(1);
    root->left = createNode(2); 
    root->right = createNode(3); 
    root->left->left = createNode(4); 
    root->left->right = createNode(5); 
    root->right->left = createNode(6); 
    root->right->right = createNode(7); 
    root->right->left->right = createNode(8);

    treeNode* val1 = createNode(4);
    treeNode* val2 = createNode(6);

    printTree(root);

    printf("Distance is: %d\n", lowestDist(root, val1, val2));

    return 0;
}

void printTree(treeNode* root){
    
    if(root!=NULL){
        printTree(root->left);
        printf("%d ",root->val);
        printTree(root->right);
    }
}

int lowestDist(treeNode* root, treeNode* p, treeNode* q){

    treeNode* LCA = findLCA(root, p, q);

    int dist_q = distance(root, q, 0);
    int dist_p = distance(root, p, 0);
    int dist_LCA = distance(root, LCA, 0);

    return dist_q + dist_p - 2*dist_LCA;
}

treeNode* findLCA(treeNode* root, treeNode* p, treeNode* q){

    if(root == NULL)
        return NULL;
    else if(root->val == p->val || root->val == q->val)
        return root;
    else{
        struct treeNode* left = findLCA(root->left, p, q);
        struct treeNode* right = findLCA(root->right, p ,q);

        if(left!=NULL && right!=NULL)
            return root;
        else if(left!=NULL && right==NULL)
            return left;
        else if(left==NULL && right!=NULL)
            return right;
        else
            return NULL;
    }
}

int distance(treeNode* p, treeNode* q, int dist){

    if (p == NULL) {
        return -1;
    }
    if (p->val == q->val) {
        return dist;
    }

    int left = distance(p->left, q, dist + 1);
    int right = distance(p->right, q, dist + 1);
    if (left > right) {
        return left;
    } else {
        return right;
    }
}

//Util
treeNode* createNode(int val){

    treeNode* new_node = (treeNode*)malloc(sizeof(treeNode));
    new_node->val = val;
    new_node->left = NULL;
    new_node->right = NULL;

    return new_node;
}