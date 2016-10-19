import java.util.Scanner;

public class Test{
    public static void main(String [] args){
        Time t = new Time(12, 50, "am");
        Time t2 = new Time(1, 1, "pm");
        Scanner sc = new Scanner(System.in);

        t.shift(sc.nextInt(), sc.nextInt());
        t.print(System.out);
        if(t.isAfter(t2))
            System.out.println("t viene prima");
        else
            System.out.println("t viene dopo");
    }
}
