import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;

public class Concessionaria{

    public Concessionaria(Scanner scNuove, Scanner scUsate) throws Exception{
        auto = new ArrayList<Auto>();

        Auto a = AutoNuova.read(scNuove);
        while(a!=null){
            auto.add(a);
            a=AutoNuova.read(scNuove);
        }

        a=AutoUsata.read(scUsate);
        while(a!=null){
            auto.add(a);
            a=AutoUsata.read(scUsate);
        }
    }

    public void print(PrintStream ps){
        for(Auto a: auto){
            if(a instanceof AutoNuova)
                ps.print("Auto Nuova: ");
            else
                ps.print("Auto Usata: ");
            ps.println(a.toString());
        }
    }

    private ArrayList<Auto> auto;
}