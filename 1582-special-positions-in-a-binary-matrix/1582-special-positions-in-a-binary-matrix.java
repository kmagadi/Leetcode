class Solution 
{
    public int numSpecial(int[][] mat) 
    {
        int result = 0;

        for( int i = 0; i < mat.length; i++ )
        {
            for( int j = 0; j < mat[ 0 ].length; j++ )
            {
                if( mat[ i ][ j ] == 1 )
                {
                    if( checkRow( mat, i ) && checkCol( mat, j ))
                        result += 1;
                }
            }
        }

        return result;
    }
    private boolean checkRow( int[][] mat, int rowInd )
    {
        int oneCtr = 0;
        for( int i = 0; i < mat[0].length; i++ )
        {
            if( mat[ rowInd ][ i ] == 1 )
                oneCtr++;
        }
        return oneCtr == 1;
    }
    private boolean checkCol( int[][] mat, int colInd )
    {
        int oneCtr = 0;
        for( int i = 0; i < mat.length; i++ )
        {
            if( mat[ i ][ colInd ] == 1 )
                oneCtr++;
        }
        return oneCtr == 1;
    }
}