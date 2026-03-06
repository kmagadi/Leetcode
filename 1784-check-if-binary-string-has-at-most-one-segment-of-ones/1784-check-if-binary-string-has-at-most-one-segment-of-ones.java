class Solution 
{
    public boolean checkOnesSegment( String s ) 
    {
        int numOfOneSegments = 1;

        for ( int i = 1; i < s.length(); i++ ) 
        {
            if ( s.charAt( i ) == '1' && s.charAt( i - 1 ) == '0' ) 
            {
                numOfOneSegments++;
            }
        }

        return numOfOneSegments <= 1;
    }
}