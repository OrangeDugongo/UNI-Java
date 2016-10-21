import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String [] args) throws Exception{
        File srcStudenti = new File("Studenti.dati");
        File srcEsami = new File("Esami.dati");
        Scanner sc = new Scanner(System.in);
        Esame e;
        Studente s;
        int i=0;
        double media=0;
        String nome, cnome;

        System.out.println("Inserisci il nome dello studente");
        nome=sc.nextLine();
        System.out.println("Inserisci il cognome dello studente");
        cnome=sc.nextLine();

        sc=new Scanner(srcStudenti);
        s=Studente.read(sc);
        while(s!=null){
            if(s.lookUp(nome, cnome)){
                sc=new Scanner(srcEsami);
                e=Esame.read(sc);
                while(e!=null){
                    if(e.lookUp(s.getMat())){
                        media+=e.getVoto();
                        i++;
                    }
                    e=Esame.read(sc);
                }
                break;
            }
            s=Studente.read(sc);
        }

        if(s!=null)
            System.out.println("lo studente "+s.getNomeCognome()+" ha la media di: "+media/i);
        else
            System.out.println("Impossibile trovare delle corrispondenze.");
    }
}
