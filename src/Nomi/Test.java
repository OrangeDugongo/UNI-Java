import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args)throws Exception{
        File fl = new File("persone.dat");
        Scanner sc = new Scanner(fl);
        Anagrafe an=new Anagrafe(sc);
        an.print(System.out);
    }
}