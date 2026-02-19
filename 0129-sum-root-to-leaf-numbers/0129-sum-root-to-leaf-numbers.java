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
class Solution 
{
    public int sumNumbers( TreeNode root ) 
    {
        return recurse( root, 0 );
    }
    private int recurse( TreeNode root, int currSum )
    {
        currSum = currSum * 10 + root.val;

        if( root.right == null && root.left == null )
        {
            return currSum;
        }

        int total = 0;
        
        if( root.left != null )
            total += recurse( root.left, currSum );
        if( root.right != null )
            total += recurse( root.right, currSum );

        return total;
    }
}