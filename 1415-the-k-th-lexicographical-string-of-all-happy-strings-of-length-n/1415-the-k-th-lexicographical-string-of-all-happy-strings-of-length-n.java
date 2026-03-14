class Solution 
{
    public String getHappyString( int n, int k ) 
    {
        ArrayList< String > resList = new ArrayList<>();

        backtrack( n, resList, new StringBuilder() );

        if( resList.size() >= k )
            return resList.get( k - 1 );
        else
            return "";
    }

    private void backtrack( int n, ArrayList< String > resList, StringBuilder currStr )
    {
        if( currStr.length() == n )
        {
            resList.add( currStr.toString() );
            return;
        }

        for( int i = 0; i < 3; i++ )
        {
            char nextChar = ( char ) ( 'a' + i );
            
            if( currStr.length() == 0 || currStr.charAt( currStr.length() - 1 ) != nextChar )
            {
                currStr.append( nextChar );
                backtrack( n, resList, currStr );
                currStr.deleteCharAt( currStr.length() - 1 ); 
            }
        }
    }
}