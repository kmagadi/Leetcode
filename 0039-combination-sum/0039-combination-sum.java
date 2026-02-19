class Solution 
{
    public List< List< Integer >> combinationSum( int[] candidates, int target ) 
    {
        List< List< Integer >> resList = new ArrayList<>();

        backtrack( candidates, 0, target, 0, new ArrayList< Integer >(), resList );

        return resList;
    }
    private void backtrack( int[] candidates, int currSum, int target, int currInd, List< Integer > currList, List< List< Integer >> resList )
    {
        if( currSum == target )
        {
            resList.add( new ArrayList<>( currList ) );
            return;
        }
        if( currSum > target )
        {
            return;
        }

        for( int i = currInd; i < candidates.length; i++ )
        {
            currList.add( candidates[ i ] );

            backtrack( candidates, currSum + candidates[ i ], target, i, currList, resList );

            currList.remove( currList.size() - 1  );
        }
    }
}