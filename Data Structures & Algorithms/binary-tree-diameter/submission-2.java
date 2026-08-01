/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;
       return Math.max(heightAtNode(root.left) + heightAtNode(root.right),  
                Math.max(
                    diameterOfBinaryTree(root.left),
                    diameterOfBinaryTree(root.right)
                )        
                );
        
    }

    public int heightAtNode(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(heightAtNode(root.left), heightAtNode(root.right));
    }


}
