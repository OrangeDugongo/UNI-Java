import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args)throws Exception{
        Trivago tri=new Trivago(new Scanner(new File("albergo.dat")));
        tri.filtroTV().print(System.out);
    }
}