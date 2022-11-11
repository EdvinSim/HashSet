
//A set implementet with Linear Probing. It can only contain integers.

class HashSet {


    //Integer class so that we can compare to null.
    Integer arr[];

    //Number of elements not null in arr.
    int size;

    final double LoadFactorThreshold = 0.75;

    public HashSet() {
        arr = new Integer[100];
        size = 0;
    }


    public boolean contains(int x) {
        return get(x) != null;
    }


    //Returns x from array. Returns null if x not in array.
    public Integer get(int x) {
        int i = x % arr.length;

        while(arr[i] != null) {

            if(x == arr[i]) {
                return arr[i];
            }
            else {
                i = ++i % arr.length;
            }
        }

        return null;
    }


    public void insert(int x) {
        capacity();

        int length = arr.length;
        int i = x % length;

        while(arr[i] != null) {
            if(x == arr[i]) { //Then x already exists.
                arr[i] = x;
                return;
            }
            else {
                i = ++i % length;
            }
        }

        size++;
        arr[i] = x;
    }

    
    public void remove(int x) {
        int i = x % arr.length;

        while(arr[i] != null) {
            if(x == arr[i]) {
                size--;
                arr[i] = null;
                fillHole(i);
                return;
            }
            else {
                i = ++i % arr.length;
            }
        }
    }

    //Returns the number of elements in arr.
    public int size() {
        return size;
    }


    //For testing if this.size is true size.
    public int countSize() {
        int size = 0;

        for(Integer num :arr) {
            if(num != null) size++;
        }

        return size;
    }


    //Fill hole on index i.
    public void fillHole(int i) {
        int len = arr.length;
        int s = 1;
        int pointer = (i+s) % len;

        while(arr[pointer] != null) {
            int value = arr[pointer];
            int j = value % len;

            if(!(0 < ((j-i) % len) && ((j-i) % len) <= s)) {
                arr[i] = value;
                arr[pointer] = null;
                fillHole(pointer);
                return;
            }

            s += 1;
            pointer = (i+s) % len;
        }
    }


    private void capacity() {
        double loadfactor = (double)size/arr.length;
        
        if(loadfactor >= LoadFactorThreshold) {
            rehash();
        }
    }


    //Doubles array size.
    private void rehash() {
        Integer[] old = arr;
        arr = new Integer[old.length * 2];
        size = 0; //Because insert counts size.

        for(int i=0; i < old.length; i++) {
            if(old[i] != null) {
                insert(old[i]);
            }
        }
    }


    public Integer[] getArray() {
        return arr;
    }
}