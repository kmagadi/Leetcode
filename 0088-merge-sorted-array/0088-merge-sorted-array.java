class Solution 
{
    public void merge( int[] nums1, int m, int[] nums2, int n ) 
    {
        int tptr1 = m - 1;
        int tptr2 = n - 1;
        int processedTill = m + n - 1;

        while( tptr1 >= 0 && tptr2 >= 0 && processedTill >= 0 )
        {
            if( nums1[ tptr1 ] >= nums2[ tptr2 ] )
            {
                nums1[ processedTill ] = nums1[ tptr1 ];
                tptr1--;
                processedTill--;
            }
            else
            {
                nums1[ processedTill ] = nums2[ tptr2 ];
                tptr2--;
                processedTill--;
            }
        }

        if( tptr1 < 0 && tptr2 >= 0 )
        {
            while( tptr2 >= 0 )
            {
                nums1[ processedTill ] = nums2[ tptr2 ];
                tptr2--;
                processedTill--;
            }
        }
    }
}