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

    public boolean lookUp(String nome, String cnome){
        if(this.nome.equals(nome) && this.cnome.equals(cnome))
            return true;
        return false;
    }

    public static Studente read(Scanner sc) throws Exception{
        String nome;
        String cnome;
        int mat;
        if(sc.hasNext()){
            nome=sc.next();
            if(sc.hasNext()){
                cnome=sc.next();
                if(sc.hasNextInt()){
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
