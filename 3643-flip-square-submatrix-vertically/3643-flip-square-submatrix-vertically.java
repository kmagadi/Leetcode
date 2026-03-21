class Solution 
{
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) 
    {
        int lastProcessedRow = x + k - 1;
        boolean[] rowProcessed = new boolean[ grid.length ];

        for( int i = 0; i < grid.length; i++ ) 
        {
            if( i >= x && !rowProcessed[ i ] && i < lastProcessedRow )
            {
                swap( grid, i, lastProcessedRow, y, k );
                rowProcessed[ i ] = true;
                lastProcessedRow -= 1;
            }
        }

        return grid;
    }
    private static void swap( int[][] grid, int row1, int row2, int y, int k )
    {
        int[] temp = new int[ grid[ row1 ].length ];

        Arrays.fill( temp, -100 );

        for (int i = y; i < y + k; i++ )
        {
            temp[ i ] = grid[ row1 ][ i ];
        }

        for( int i = y; i < y + k; i++ )
        {
            grid[ row1 ][ i ] = grid[ row2 ][ i ];
        }
        
        for( int i = y; i < y + k; i++ )
        {
            if( temp[ i ] != -100 )
                grid[ row2 ][ i ] = temp[ i ];
        }
        
    }
}