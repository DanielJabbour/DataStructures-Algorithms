/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* travAndCopy(struct TreeNode* t1, struct TreeNode* t2, struct TreeNode* treeMergeNode);
struct TreeNode* createNode(int val);

struct TreeNode* mergeTrees(struct TreeNode* t1, struct TreeNode* t2) {

    if(t1 == NULL && t2 == NULL)
        return NULL;
    if(t1 == NULL && t2 != NULL)
        return t2;
    if(t1 != NULL && t2 == NULL)
        return t1;
    
    else {
        int mergeVal = t1->val + t2->val;
    
        struct TreeNode* firstNode = createNode(mergeVal);

        return travAndCopy(t1, t2, firstNode);
    }
    
}

struct TreeNode* travAndCopy(struct TreeNode* t1, struct TreeNode* t2, struct TreeNode* treeMergeNode) {
    
    //Value exists for both nodes
    if (t1->left!=NULL && t2->left!=NULL){
        int mergeVal = t1->left->val + t2->left->val;
        struct TreeNode* new_node = createNode(mergeVal);
        treeMergeNode->left = new_node;
        
        travAndCopy(t1->left, t2->left, treeMergeNode->left);
    }
    
     if (t1->right!=NULL && t2->right!=NULL){
        int mergeVal = t1->right->val + t2->right->val;
        struct TreeNode* new_node = createNode(mergeVal);
        treeMergeNode->right = new_node;
        
        travAndCopy(t1->right, t2->right, treeMergeNode->right);
    }
    
    if (t1->left != NULL && t2->left == NULL)
        treeMergeNode->left = t1->left;
    if (t1->right != NULL && t2->right == NULL)
        treeMergeNode->right = t1->right;
    if (t1->left == NULL && t2->left != NULL)
        treeMergeNode->left = t2->left;
    if (t1->right == NULL && t2->right != NULL)
        treeMergeNode->right = t2->right;
        
    return treeMergeNode;
}

struct TreeNode* createNode(int val){
    struct TreeNode* new_node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    new_node->val = val;
    new_node->left = NULL;
    new_node->right = NULL;
    
    return new_node;
}