class Solution 
{
    public List< List< Integer >> combine( int n, int k ) 
    {
        List< List< Integer >> resList = new ArrayList<>();

        backtrack( n, k, new ArrayList<>(), resList, 1 );

        return resList;
    }
    private void backtrack( int n, int k, List< Integer > currList, List< List< Integer >> resList, int currNum )
    {
        if( currList.size() == k )
        {
           resList.add( new ArrayList<>( currList ));
           return;
        }
        for( int i = currNum; i <= n; i++ )
        {
            currList.add( i );
            
            backtrack( n, k, currList, resList, i + 1 );

            currList.remove( currList.size() - 1 );
        }
    }
}