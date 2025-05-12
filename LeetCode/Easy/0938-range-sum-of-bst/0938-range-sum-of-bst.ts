/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

let sum;
function rangeSumBST(root: TreeNode | null, low: number, high: number): number {
    if (root == null) return 0;

    sum = 0;

    searchNode(root, low, high);
    return sum;
};

function searchNode(node: TreeNode | null, low: number, high: number){

    if(node == null){
        return;
    }
    
    if(node.val > low){
        searchNode(node.left, low, high);
    }
    
    if(node.val >= low && node.val <= high){
        sum += node.val;
    }
    
    
    if(node.val < high) {
        searchNode(node.right, low, high);
    }
    
    
}