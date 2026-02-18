class RandomizedSet 
{
    class Node {
        int value;
        int listIndex; // MUST store the index in the 'list' array
        Node next;

        Node(int value, int listIndex) {
            this.value = value;
            this.listIndex = listIndex;
        }
    }

    private Node[] table;     
    private int[] list;       
    private int currOccupied;
    private int currSize;
    private java.util.Random rand; 

    public RandomizedSet() 
    {
        currSize = 10;
        table = new Node[ currSize ];
        list = new int[ 100005 ]; 
        currOccupied = 0;
        rand = new java.util.Random();
    }

    public boolean insert( int val ) 
    {
        if (contains(val)) return false;
        list[ currOccupied ] = val;
        int hashCode = getHash( val );
        Node newNode = new Node( val, currOccupied );
        newNode.next = table[ hashCode ];
        table[ hashCode ] = newNode;
        
        currOccupied++;
        return true;
    }

    public boolean remove( int val ) 
    {
        int hashCode = getHash( val );
        Node tptr = table[hashCode];
        Node prev = null;
        
        while ( tptr != null ) 
        {
            if ( tptr.value == val ) 
            {
                int indexInList = tptr.listIndex; 
                int lastVal = list[currOccupied - 1];
                list[ indexInList ] = lastVal;
                
                updateIndexInTable(lastVal, indexInList);
                
                if ( prev == null ) table[ hashCode ] = tptr.next;
                else prev.next = tptr.next;
                
                currOccupied--;
                return true;
            }
            prev = tptr;
            tptr = tptr.next;
        }
        return false;
    }

    private void updateIndexInTable( int val, int newIndex ) 
    {
        int hashCode = getHash( val );
        Node tptr = table[ hashCode ];
        while ( tptr != null ) 
        {
            if ( tptr.value == val ) 
            {
                tptr.listIndex = newIndex;
                return;
            }
            tptr = tptr.next;
        }
    }

    public boolean contains( int key )
    {
        int hashCode = getHash( key );
        Node tptr = table[ hashCode ];
        
        while( tptr != null )
        {
            if( tptr.value == key )
                return true;
            
            tptr = tptr.next;
        }

        return false;
    }

    private int getHash( int key ) 
    {
        return Math.abs( key ) % currSize;
    }

    public int getRandom() 
    {
        int randomIndex = rand.nextInt(currOccupied);
        return list[randomIndex];
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */