import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet hs = new HashSet();

        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < lines; i++) {
            String line[] = sc.nextLine().split(" ");
            String command = line[0];

            if(command.equals("size")) {
                System.out.println(hs.size());
            }
            else if(command.equals("insert")) {
                hs.insert(Integer.parseInt(line[1]));
            }
            else if(command.equals("contains")) {
                System.out.println(hs.contains(Integer.parseInt(line[1])));
            }
            else if(command.equals("remove")) {
                hs.remove(Integer.parseInt(line[1]));
            }
            else {
                System.out.println("Feil i innlesning!");
            }
        }

        sc.close();

    }
}
