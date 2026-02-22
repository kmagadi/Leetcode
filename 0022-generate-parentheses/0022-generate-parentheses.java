class Solution 
{
    public List< String > generateParenthesis( int n ) 
    {
        List< String > resList = new ArrayList<>();

        backtrack( n, 0, 0, resList, new StringBuilder() );
        
        return resList;
    }

    private void backtrack( int n, int openBraces, int closeBraces, List<String> resList, StringBuilder sb ) 
    {
        if ( sb.length() == n * 2 ) 
        {
            resList.add( sb.toString() );
            return;
        }
        if ( openBraces < n ) 
        {
            sb.append( '(' );
            backtrack( n, openBraces + 1, closeBraces, resList, sb );
            sb.deleteCharAt(sb.length() - 1);
        }

        if ( closeBraces < openBraces ) 
        {
            sb.append( ')' );
            backtrack( n, openBraces, closeBraces + 1, resList, sb );
            sb.deleteCharAt( sb.length() - 1 );
        }
    }
}