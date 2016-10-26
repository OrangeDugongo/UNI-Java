import java.util.Scanner;
import java.io.PrintStream;

public class Studente{

    public Studente(String nome, String cnome, int matricola){
        this.nome=nome;
        this.cnome=cnome;
        this.matricola=matricola;
    }

    public int getMatricola(){
        return matricola;
    }

    public String getNomeCognome(){
        return nome.concat(" ").concat(cnome);
    }

    public boolean equals(String nome, String cnome){
        return this.nome.equals(nome) && this.cnome.equals(cnome);
    }

    public static Studente read(Scanner sc) throws Exception{
        String nome;
        String cnome;
        int matricola;

        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNextInt()) return null;
        matricola=sc.nextInt();

        return new Studente(nome, cnome, matricola);
    }

    public String toString(){
        return nome + " " + cnome + " " + matricola;
    }

    public void print(PrintStream ps){
        ps.println(toString());
    }

    private String nome;
    private String cnome;
    private int matricola;
}
