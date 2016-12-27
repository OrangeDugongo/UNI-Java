import java.util.Scanner;

public class Test{
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleList list = new SimpleList();

        System.out.println("Stringa: ");
        String line = sc.nextLine();

        while(!line.equals("")) {
            list.addHead(line);
            System.out.println("Stringa: ");
            line = sc.nextLine();
        }

        System.out.println("lunghezza lista: " + list.size());

        while(!list.isEmpty()){
            line = (String) list.head();
            System.out.println(line);
            list.remHead();
        }
    }
}