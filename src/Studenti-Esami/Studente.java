import java.util.Scanner;

public class Studente{

    public Studente(String nome, String cnome, int mat){
        this.nome=nome;
        this.cnome=cnome;
        this.mat=mat;
    }

    public int getMat(){
        return mat;
    }

    public String getNomeCognome(){
        return nome.concat(" ").concat(cnome);
    }

    public Studente lookUp(String nome, String cnome){
        if(this.nome.equals(nome) && this.cnome.equals(cnome))
            return this;
        return null;
    }

    public static Studente read(Scanner sc) throws Exception{
        String nome;
        String cnome;
        int mat;
        if(sc.hasNext()){
            nome=sc.nextLine();
            if(sc.hasNext()){
                cnome=sc.nextLine();
                if(sc.hasNext()){
                    mat=sc.nextInt();
                    return new Studente(nome, cnome, mat);
                }
            }
        }
        return null;
    }

    private String nome;
    private String cnome;
    private int mat;
}
