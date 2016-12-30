import java.io.PrintStream;

abstract public class Opera{
    public Opera(String autore, String titolo, int anno, String pos){
        this.anno=anno;
        this.autore=autore;
        this.titolo=titolo;
        this.pos=pos;
    }

    public int getAnno(){
        return anno;
    }

    public String getAutore(){
        return autore;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getPos(){
        return pos;
    }

    public int hashCode(){
        return autore.hashCode()*titolo.hashCode()*pos.hashCode()*anno;
    }

    abstract public void print(PrintStream ps);

    protected int anno;
    protected String autore;
    protected String titolo;
    protected String pos;
}