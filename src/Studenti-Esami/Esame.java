import java.util.Scanner;

public class Esame{

    public Esame(String nome, int voto, int mat){
        this.nome=nome;
        this.voto=voto;
        this.mat=mat;
    }

    public int getVoto(){
        return voto;
    }

    public int getMat(){
        return mat;
    }

    public String getNome(){
        return nome;
    }

    public boolean lookUp(int mat){
        if(this.mat==mat)
            return true;
        return false;
    }

    public static Esame read(Scanner sc) throws Exception{
        String nome;
        int voto;
        int mat;
        if(sc.hasNext()){
            nome=sc.next();
            if(sc.hasNextInt()){
                voto=sc.nextInt();
                if(sc.hasNextInt()){
                    mat=sc.nextInt();
                    return new Esame(nome, voto, mat);
                }
            }
        }
        return null;
    }

    private String nome;
    private int voto;
    private int mat;
}
