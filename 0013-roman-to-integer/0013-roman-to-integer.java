class Solution 
{
    public int romanToInt( String s ) 
    {
        int currSum = 0;
        boolean lastCharProcessed = false;

        for( int i = 0; i < s.length() - 1; i++ )
        {
            if( checkPrecedence( s.charAt( i ) ) >= checkPrecedence( s.charAt( i + 1 )))
            {
                currSum += getValue( s.charAt( i ) );
                lastCharProcessed = false;
            }
            else
            {
                int greater = getValue( s.charAt( i + 1 ));
                int smaller = getValue( s.charAt( i ) );
                currSum += ( greater - smaller );
                
                if (i + 1 == s.length() - 1) {
                    lastCharProcessed = true;
                }
                
                i += 1; 
            }
        }

        if( !lastCharProcessed )
        {
            currSum += getValue(s.charAt(s.length() - 1));
        }
        
        return currSum;
    }

    private int getValue( char ch )
    {
        int val;
        switch ( ch ) 
        {
            case 'I': val = 1; break;
            case 'V': val = 5; break;
            case 'X': val = 10; break;
            case 'L': val = 50; break;
            case 'C': val = 100; break;
            case 'D': val = 500; break;
            case 'M': val = 1000; break;
            default: val = 0;
        }
        return val;
    }

    private int checkPrecedence( char ch )
    {
        int val;
        switch ( ch ) 
        {
            case 'I': val = 0; break;
            case 'V': val = 1; break;
            case 'X': val = 2; break;
            case 'L': val = 3; break;
            case 'C': val = 4; break;
            case 'D': val = 5; break;
            case 'M': val = 6; break;
            default: val = 0;
        }
        return val;
    } 
}