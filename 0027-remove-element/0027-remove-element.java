class Solution 
{
    public int removeElement( int[] nums, int val ) 
    {
        if( nums.length == 0 ) return 0;
        if( nums.length == 1 && nums[ 0 ] == val )
            return 0;
        if( nums.length == 1 && nums[ 0 ] != val ) 
            return 1;

        int[] tempArr = new int[ nums.length ];
        Arrays.fill( tempArr, -100 );
        int tempInd = 0;

        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[ i ] != val )
            {
                tempArr[ tempInd ] = nums[ i ];
                tempInd++;
            }
        }

        for( int i = 0; i < nums.length; i++ )
        {
            if( tempArr[ i ] == -100 ) 
                break;
            nums[ i ] = tempArr[ i ];
        }
        
        return tempInd;
    }
}