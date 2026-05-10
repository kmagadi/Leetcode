class Solution 
{
    public int maxDistinct( String s ) 
    {
        int[] freqArr = new int[ 26 ];
        int result = 0;

        for( char ch : s.toCharArray() )
        {
            freqArr[ ch - 'a' ] += 1;
        } 

        for( int i = 0; i < freqArr.length; i++ )
        {
            if( freqArr[ i ] >= 1 )
                result += 1;
        }

        return result; 
    }
}