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
        boolean trovato = false;
        double media=0;
        String nome, cnome;

        System.out.println("Inserisci il nome dello studente");
        nome=sc.nextLine();
        System.out.println("Inserisci il cognome dello studente");
        cnome=sc.nextLine();

        sc=new Scanner(srcStudenti);
        s=Studente.read(sc);
        while(s!=null && !trovato){
            s=s.lookUp(nome, cnome);
            if(s!=null){
                trovato=true;
                sc=new Scanner(srcEsami);
                e=Esame.read(sc);
                while(e!=null){
                    e=e.lookUp(s.getMat());
                    if(e!=null){
                        media+=e.getVoto();
                        i++;
                    }
                    e=Esame.read(sc);
                }
            }
            s=Studente.read(sc);
        }

        System.out.println("lo studente "+s.getNomeCognome()+"ha la media di: "+media/i);
    }
}
