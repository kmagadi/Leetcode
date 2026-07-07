class Solution 
{
    public int majorityElement( int[] nums ) 
    {
        int count = 1;
        int currEle = nums[ 0 ];

        for( int i = 1; i < nums.length; i++ )
        {
            if( currEle == nums[ i ] )
            {
                count++;
            }
            if( currEle != nums[ i ] )
            {
                count--;
                if( count <= 0 )
                {
                    currEle = nums[ i ];
                    count = 1;
                }
            }
        }

        return currEle;
    }
}