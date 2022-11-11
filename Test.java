public class Test {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.insert(123);
        if(!hs.contains(123)) System.out.println("Feil!");
        if(hs.contains(124)) System.out.println("Feil!");
        hs.remove(123);

        System.out.println("Test gjennomfort");
        if(hs.contains(123)) System.out.println("Feil!");
    }

    //Checks if there are any values that are the same.
    public static void checkDuplicates(Integer[] arr) {
        for(Integer i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                for(Integer j = i+1; j < arr.length; j++) {
                    if(arr[j] != null && arr[i] == arr[j]) {
                        System.out.println(arr[j] + " er lik " + arr[i]);
                    }
                }
            }
        }
    }
}
