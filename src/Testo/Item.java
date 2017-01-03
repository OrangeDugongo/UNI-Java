import java.util.Scanner;
import java.io.PrintStream;

public class Item{

    public Item(String parola){
        this.parola=parola;
        this.n=1;
    }

    public static Item read(Scanner sc){
        if(!sc.hasNext()) return null;
        return new Item(sc.next());
    }

    public String getParola(){
        return parola;
    }

    public int getN(){
        return n;
    }

    public void setAdd(){
        n++;
    }

    public void print(PrintStream ps){
        ps.println(parola+" = "+n);
    }

    private String parola;
    private int n;
}