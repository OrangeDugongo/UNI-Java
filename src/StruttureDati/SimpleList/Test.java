import java.util.Scanner;

public class Test{
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ListNI list = new ListNI();
        ListNI list2;

        System.out.println("Stringa: ");
        String line = sc.nextLine();

        while(!line.equals("")) {
            list.addHead(line);
            System.out.println("Stringa: ");
            line = sc.nextLine();
        }

        list2=list.copy();
        list2.addAt(3, "prova");
        list.remAt(2);

        while(!list.isEmpty()){
            line = (String) list.head();
            System.out.print(line+" --> ");
            list.remHead();
        }
        System.out.println();
        while(!list2.isEmpty()){
            line = (String) list2.head();
            System.out.print(line+" --> ");
            list2.remHead();
        }
    }
}