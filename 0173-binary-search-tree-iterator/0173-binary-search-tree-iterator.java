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
class BSTIterator
{
    List< Integer > refList;
    int ptr;

    private void inorder( TreeNode root, List< Integer > refList )
    {
        if( root == null )
            return;
        
        inorder( root.left, refList );
        refList.add( root.val );
        inorder( root.right, refList );
    }

    public BSTIterator( TreeNode root ) 
    {
        refList = new ArrayList<>();
        inorder( root, refList );

        System.out.println( refList );

        ptr = -1;
    }
    
    public int next() 
    {
        ptr += 1;
        if( ptr < refList.size() )
            return refList.get( ptr );
        else
            return refList.get( 0 );
    }
    
    public boolean hasNext() 
    {
        if( ptr < refList.size() - 1 )
            return true;
        else 
            return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */