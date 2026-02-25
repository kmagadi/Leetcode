class Solution 
{
    public int[] sortByBits(int[] arr) 
    {
        Integer[] boxedArray = Arrays.stream( arr ).boxed().toArray( Integer[]::new );

        Arrays.sort( boxedArray, ( a, b ) -> 
        {
            int countA = Integer.bitCount( a );
            int countB = Integer.bitCount( b );

            if ( countA == countB ) 
            {
                return a - b;
            }
            return countA - countB;
        });

        return Arrays.stream( boxedArray ).mapToInt( Integer :: intValue ).toArray();
    }
}