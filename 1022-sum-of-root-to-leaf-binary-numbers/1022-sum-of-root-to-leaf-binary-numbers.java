class Solution 
{
    public int sumRootToLeaf( TreeNode root ) 
    {
        ArrayList< String > paths = new ArrayList<>();
        generatePath( root, paths, new StringBuilder() );
        
        int result = 0;
        for (String s : paths) 
        {
            result += Integer.parseInt( s, 2 );
        }
        return result;
    }

    private void generatePath( TreeNode root, ArrayList< String > paths, StringBuilder temp ) 
    {
        if ( root == null ) return;

        temp.append( root.val );

        if ( root.left == null && root.right == null ) 
        {
            paths.add(temp.toString());
        } 
        else 
        {
            generatePath( root.left, paths, temp );
            generatePath( root.right, paths, temp );
        }

        temp.deleteCharAt( temp.length() - 1 );
    }
}