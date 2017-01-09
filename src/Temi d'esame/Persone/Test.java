import java.io.File;
import java.util.Scanner;
import java.util.Collections;

public class Test{
    public static void main(String [] args)throws Exception{
        File fl = new File("persone.dat");
        AlberoBinarioDiRicerca tree = new AlberoBinarioDiRicerca(new Scanner(fl), new PesoComparator());
        tree.sort(new NomeComparator()).print(System.out);
    }
}