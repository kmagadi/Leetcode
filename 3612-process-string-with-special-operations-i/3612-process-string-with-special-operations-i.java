class Solution 
{
    public String processStr( String s ) 
    {
        Stack< Character > stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for( char ch : s.toCharArray() )
        {
            if( isLetter( ch ))
            {
                res.append( ch );
            }
            else
            {
                if( ch == '*' )
                {
                    if( res.length() > 0 )
                        res.deleteCharAt( res.length() - 1 );
                }
                else if( ch == '#' )
                {
                    res.append( res.toString() );
                }
                else if( ch == '%' )
                {
                    res.reverse();
                }
            }
        }
            
        return res.toString();
    }
    private boolean isLetter( char ch )
    {
        if( ch - 'a' >= 0 && ch - 'a' <= 26 )
            return true;
        return false;
    }
}