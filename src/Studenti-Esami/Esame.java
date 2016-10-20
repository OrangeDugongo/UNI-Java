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

    public Esame lookUp(int mat){
        if(this.mat==mat)
            return this;
        return null;
    }

    public static Esame read(Scanner sc) throws Exception{
        String nome;
        int voto;
        int mat;
        if(sc.hasNext()){
            nome=sc.nextLine();
            if(sc.hasNext()){
                voto=sc.nextInt();
                if(sc.hasNext()){
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
