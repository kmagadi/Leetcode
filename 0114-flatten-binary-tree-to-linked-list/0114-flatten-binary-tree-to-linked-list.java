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
    public void flatten( TreeNode root ) 
    {
        if( root == null ) return;

        List< TreeNode > list = new ArrayList<>();

        preorderTrav( root, list );

        TreeNode tptr = list.get( 0 );

        for( int i = 1; i < list.size(); i++ )
        {
            TreeNode temp = list.get( i );
            tptr.left = null;
            tptr.right = temp;
            tptr = tptr.right;
        }
    }

    private void preorderTrav( TreeNode root, List< TreeNode > list )
    {
        if( root == null )
        {
            return;
        }

        list.add( root );
        preorderTrav( root.left, list );
        preorderTrav( root.right, list );
    }
}