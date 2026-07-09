class Solution 
{
    public void sortColors(int[] nums) 
    {
        int start = -1;
        int mid = 0;
        int end = nums.length;

        while( mid < end )
        {
            if( nums[ mid ] == 0 )
            {
                swap( nums, start + 1, mid );
                start += 1;
                mid += 1;
            }
            else if( nums[ mid ] == 1 )
            {
                mid += 1;
            }
            else if( nums[ mid ] == 2 )
            {
                swap( nums, mid, end - 1 );
                end -= 1;
            }
        }    
    }

    private void swap( int[] nums, int ind1, int ind2 )
    {
        int temp = nums[ ind1 ];
        nums[ ind1 ] = nums[ ind2 ];
        nums[ ind2 ] = temp;
    }
}