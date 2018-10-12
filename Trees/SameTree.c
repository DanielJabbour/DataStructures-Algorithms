/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int getTreeSize(struct TreeNode* treeNode);
bool Traverse(struct TreeNode* p, struct TreeNode* q);

bool isSameTree(struct TreeNode* p, struct TreeNode* q) {    
    
    //Traverse tree in same order, if value is equal, continue traversal
    
    int pSize = getTreeSize(p);
    int qSize = getTreeSize(q);
    
    if (pSize != qSize)
        return 0;
    
    return Traverse(p, q);
}

bool Traverse(struct TreeNode* p, struct TreeNode* q){
    
    if (p == NULL && q == NULL)
        return 1;
    if (p == NULL && q != NULL)
        return 0;
    if (p != NULL && q == NULL)
        return 0;
    
    else {
        if(p->val != q->val)
            return 0;
        
        else { //values are equal
            int isSame = 1;
            int leftB = Traverse(p->left, q->left);
            int rightB = Traverse(p->right, q->right);
                
            if(leftB == 0 || rightB == 0) {
                isSame = 0;
            }
                        
            //This is a problem as it will return true as long as root is same
            return isSame;
        }
    }

}

int getTreeSize(struct TreeNode* treeNode){
    
    if (treeNode==NULL)
        return 0;
    else
        return getTreeSize(treeNode->left) + 1 + getTreeSize(treeNode->right);
    
}