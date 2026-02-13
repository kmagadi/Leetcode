class Solution 
{
    private static void reversePart( int[] arr, int start, int end ) 
    {
        while ( start < end ) 
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }   
    public void rotate( int[] nums, int k ) 
    {
        k = k % nums.length;

        reversePart( nums, 0, nums.length - 1 );

        reversePart( nums, 0, k - 1 );
        reversePart( nums, k, nums.length - 1 );
    }
}