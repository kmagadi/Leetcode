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
    public TreeNode sortedArrayToBST( int[] nums ) 
    {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode( nums[ mid ] );
        root.left = generateTree( nums, 0, mid - 1 );
        root.right = generateTree( nums, mid + 1, nums.length - 1 );

        return root;
    }
    private TreeNode generateTree( int[] nums, int left, int right )
    {
        if( left > right )
            return null;

        int mid = left + ( right - left ) / 2;
        TreeNode nn = new TreeNode( nums[ mid ] );
        
        nn.left = generateTree( nums, left, mid - 1 );
        nn.right = generateTree( nums, mid + 1, right );
        
        return nn;
    }
}