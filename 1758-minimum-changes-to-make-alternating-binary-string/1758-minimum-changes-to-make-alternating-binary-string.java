class Solution 
{
    public int minOperations( String s ) 
    {
        int countStart0 = 0;
        int countStart1 = 0;
        
        for ( int i = 0; i < s.length(); i++ ) 
        {
            char current = s.charAt( i );
            
            if ( i % 2 == 0 ) 
            {
                if ( current != '0' ) countStart0++;
                if ( current != '1' ) countStart1++;
            } 
            else 
            {
                if ( current != '1' ) countStart0++;
                if ( current != '0' ) countStart1++;
            }
        }
        
        return Math.min( countStart0, countStart1 );
    }
}