class HashSet {


    //Integer class so that we can compare to null.
    Integer arr[];
    int size;
    final double LoadFactorThreshold = 0.75;

    public HashSet() {
        //TODO fikse load factor.
        arr = new Integer[100];
        size = 0;
    }

    public boolean contains(int x) {
        int i = x % arr.length;

        while(arr[i] != null) {

            if(x == arr[i]) {
                return true;
            }
            else {
                i = (i+1) % arr.length;
            }
        }

        return false;
    }

    public void insert(int x) {
        //capacity();

        int length = arr.length;
        int i = x % length;

        while(arr[i] != null) {
            if(x == arr[i]) { //Then x already exists.
                arr[i] = x;
                return;
            }
            else {
                i = (i+1) % length;
            }
        

        size++;
        arr[i] = x;
        }
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
                i = (i+1) % arr.length;
            }
        }
    }

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
        if((size/arr.length) >= LoadFactorThreshold) rehash();
    }

    private boolean _capacity() {
        if(size >= arr.length) {
            System.out.println("Array capacity is full!");
            return false;
        }
        
        else {
            return true;
        }
    }

    //Extends array size to double.
    private void rehash() {
        Integer[] old = arr;
        arr = new Integer[old.length * 2];

        for(int i=0; i < old.length; i++) {
            arr[i] = old[i];
        }
    }
}