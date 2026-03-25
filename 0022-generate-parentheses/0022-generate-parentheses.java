class Solution {
    private void helper( List<String> res, int n, int open, int close, StringBuilder currStr )
    {
        if( n == open && n == close )
        {
            res.add( currStr.toString() );
            return;
        }
        if( open > n || close > n )
            return;

        if( open < n )
        {
            helper( res, n, open + 1, close, currStr.append('(') );
            currStr.deleteCharAt( currStr.length() - 1 );
        }
        if( close < open ){
            helper( res, n, open, close + 1, currStr.append(')') );
            currStr.deleteCharAt( currStr.length() - 1 );
        }
    }
    public List<String> generateParenthesis( int n ) {
        List<String> res = new ArrayList<>();
        StringBuilder currStr = new StringBuilder();
        currStr.append('(');
        helper( res, n, 1, 0, currStr );
        return res;
    }
}