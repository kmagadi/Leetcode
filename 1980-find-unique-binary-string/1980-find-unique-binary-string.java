class Solution 
{
    private String backtrack( String[] nums, StringBuilder sb, int size )
    {
        if( sb.length() == size )
        {
            if( !contains( nums, sb.toString() ))
            {
                return sb.toString();
            }
            return "";
        }
        sb.append('1');
        String result = backtrack( nums, sb, size );
        sb.deleteCharAt( sb.length() - 1 );

        if (!result.isEmpty()) return result;
        
        sb.append('0');
        result = backtrack( nums, sb, size );
        sb.deleteCharAt( sb.length() - 1 );
        if( !result.isEmpty() )
            return result;

        return result;
    }
    public String findDifferentBinaryString( String[] nums ) 
    {
        return backtrack( nums, new StringBuilder(), nums[0].length() );
    }
    public static boolean contains( String[] arr, String target ) 
    {
        for( String s : arr ) 
        {
            if( target != null && target.equals( s )) 
            {
                return true;
            }
        }
        return false;
    }
}