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
    
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        if (root!=null) {
            sum -= root.val;
            if (sum==0 && root.left==null && root.right==null) {
                return createSingletonList(root.val);
            }
            ArrayList<ArrayList<Integer>> result = pathSum(root.left, sum);
            result.addAll(pathSum(root.right, sum));
            
            if (result.size()>0) {
                for(int i=0; i<result.size(); i++) 
                    result.get(i).add(0, root.val);
                return result;
            }
        }
        return new ArrayList<ArrayList<Integer>>(0);
    }
    
    ArrayList<ArrayList<Integer>> createSingletonList (int val) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> self = new ArrayList<>();
        self.add(val);
        result.add(self);
        return result;
    }
}