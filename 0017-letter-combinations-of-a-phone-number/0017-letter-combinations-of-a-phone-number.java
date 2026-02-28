class Solution 
{
    public List<String> letterCombinations(String digits) 
    {
        List< String > resList = new ArrayList<>();

        Map< Character, String > map = new HashMap<>();
        map.put( '0', "" );
        map.put( '1', "" );
        map.put( '2', "abc" );
        map.put( '3', "def" );
        map.put( '4', "ghi" );
        map.put( '5', "jkl" );
        map.put( '6', "mno" );
        map.put( '7', "pqrs" );
        map.put( '8', "tuv" );
        map.put( '9', "wxyz" );

        backtrack( resList, new StringBuilder(), map, digits, 0 );

        return resList; 
    }
    private void backtrack( List< String > resList, StringBuilder sb, Map< Character, String > map, String digits, int currInd  )
    {
        if( sb.length() == digits.length() )
        {
            resList.add( sb.toString() );
            return;
        }
        
        for( char ch : map.get( digits.charAt( currInd ) ).toCharArray() )
        {
            sb.append( ch );
            backtrack( resList, sb, map, digits, currInd + 1 );
            sb.deleteCharAt( sb.length() - 1 );
        }
    }
}