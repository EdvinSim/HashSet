class HashSet {


    //Integer class so that we can compare to null.
    Integer arr[];
    int size;

    public HashSet() {
        arr = new Integer[1000000];
        size = 0;
    }

    public boolean contains(int x) {
        int i = x;
        boolean exists = false;
        
        if(arr[i] != null && arr[i] == x) exists = true;
        else i++;

        //Search for x from next index.
        for(i = x+1; !exists; i++) {
            if(i == arr.length) i = 0; //If we reach end of array we search from start.

            if(arr[i] == null || i == x) return exists; //If i = x we hav made a full circle.
            else if(arr[i] == x) exists = true;
        }

        return exists;
    }

    //Insert using Linear probing
    public void insert(int x) {
        int i = x;
        boolean inserted = false;

        if(arr[i] == null) {
            arr[i] = x;
            inserted = true;
            size++;
        }
        else if(arr[i] == x) {
            inserted = true;
        }

        //Search for a free space from next index.
        for(i = x+1; !inserted; i++) {
            if(i == arr.length) i = 0; //If we reach end of array we look for a free space from start.
            else if(i == x) {
                System.out.println("Array is full!");
                return;
            }
            
            if(arr[i] == null) {
                arr[i] = x;
                inserted = true;
                size++;
            }
            else if(arr[i] == x) {
                inserted = true;
            }
        }
    }
    
    //TODO tett hull!!!!
    public void remove(int x) {
        int i = x;
        boolean removed = false;

        if(arr[i] != null && arr[i] == x) {
            arr[i] = null;
            size--;
        }

        for(i = x+1; !removed; i++) {
            if(i == arr.length) i = 0; //If we reach end of array we look for x from start.
            else if(i == x && !removed) return; //Then x is not in arr.
            
            if(arr[i] != null && arr[i] == x) {
                arr[i] = null;
                removed = true;
                size--;
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
        
    }
}