class HashSet {


    //Integer class so that we can compare to null.
    Integer arr[];
    int size;

    public HashSet() {
        //TODO fikse load factor.
        arr = new Integer[500];
        size = 0;
    }

    public boolean contains(int x) {
        int i = x % arr.length;

        while(arr[i] != null) {

            if(x == arr[i]) {
                return true;
            }

            i = (i+1) % arr.length;
        }

        return false;
    }

    public void insert(int x) {
        //x = k and v.
        if(capacity()) {
            int length = arr.length;
            int i = (x % length);

            while(arr[i] != null) {
                if(x == arr[i]) {
                    arr[i] = x;
                    return;
                }
                else {
                    i = ((i +1) % length);
                }
            }

            size++;
            arr[i] = x;
        }
    }

    
    //TODO tett hull!!!!
    public void remove(int x) {
        int i = x % arr.length;

        while(arr[i] != null) {
            int value = arr[i];//TODO unodvendig linje?

            if(x == value) {
                size--;
                arr[i] = null;
                //TODO fillHole()
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
        for(int s = 1; arr[(int)(i+s % arr.length)] != null; s++) {
            
        }
    }

    private boolean capacity() {
        if(size >= arr.length) {
            System.out.println("Array capacity is full!");
            return false;
        }
        
        else {
            return true;
        }
    }
}