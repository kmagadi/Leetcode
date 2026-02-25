class LRUCache {
    int capacity;
    int[][] arr;
    int currSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity][2];
        this.currSize = 0;
    }

    public int get(int key) {
        for (int i = 0; i < currSize; i++) {
            if (arr[i][0] == key) {
                int val = arr[i][1];
                for (int j = i; j < currSize - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[currSize - 1] = new int[]{key, val};
                return val;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < currSize; i++) {
            if (arr[i][0] == key) {
                for (int j = i; j < currSize - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[currSize - 1] = new int[]{key, value};
                return;
            }
        }

        if (currSize < capacity) {
            arr[currSize++] = new int[]{key, value};
        } else {
            for (int i = 0; i < capacity - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[capacity - 1] = new int[]{key, value};
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */