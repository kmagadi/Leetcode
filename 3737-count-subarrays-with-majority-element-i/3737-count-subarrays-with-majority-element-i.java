class Solution 
{
    public int countMajoritySubarrays( int[] nums, int target ) 
    {
        int n = nums.length;
        int count = 0;

        for( int i = 0; i < n; i++ )
        {
            int tCount = 0;
            int size = 0;
            for ( int j = i; j < n; j++ ) 
            {
                if ( nums[ j ] == target ) 
                    tCount++;
                size++;
                
                if ( tCount > size / 2 ) 
                {
                    count++;
                }
            }
        }

        return count;    
    }
}