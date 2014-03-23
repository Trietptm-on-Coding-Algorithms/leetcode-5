/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root==null)
            return false;
        sum -= root.val;
        if (sum==0) {
            if(root.left==null && root.right==null)
                return true;
            if(root.left!=null && hasPathSum(root.left, sum))
                return true;
            if(root.right!=null && hasPathSum(root.right, sum))
                return true;
            return false;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}