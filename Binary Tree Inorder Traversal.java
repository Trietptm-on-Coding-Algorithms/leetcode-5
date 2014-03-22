/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    /* Iterative approach */
    public ArrayList<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null) 
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty())
        {
            TreeNode node = stack.peek();
            if(node.left!=null)
            {
                stack.push(node.left);
                node.left = null;
                continue;
            }
            list.add(node.val);
            stack.pop();
            if(node.right!=null)
            {
                stack.push(node.right);
                node.right = null;
            }
        }
        return list;
    }
    
    /* Recursive approach */
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        if(root==null) 
            return new ArrayList<Integer>();
        ArrayList<Integer> list = inorderTraversal(root.left);
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}