class Solution 
{
    public int firstMissingPositive(int[] nums) 
    {
        int n = nums.length;
        
        for ( int i = 0; i < n; i++ ) 
        {
            while ( nums[ i ] > 0 && nums[ i ] <= n && nums[ i ] != nums[ nums[ i ] - 1 ])
            {
                swap( nums, i, nums[ i ] - 1 );
            }
        }
        
        for ( int i = 0; i < n; i++ ) 
        {
            if ( nums[ i ] != i + 1 ) 
            {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    private static void swap( int[] nums, int ind1, int ind2 )
    {
        int temp = nums[ ind1 ];
        nums[ ind1 ] = nums[ ind2 ];
        nums[ ind2 ] = temp;
    }
}