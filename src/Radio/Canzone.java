import java.util.Scanner;

public class Canzone{

    public Canzone(String titolo, String autore, String album){
        this.titolo=titolo;
        this.album=album;
        this.autore=autore;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getAutore(){
        return autore;
    }

    public String getAulbum(){
        return album;
    }

    public String toString(){
        return titolo+" "+autore+" "+album+".";
    }

    public static Canzone read(Scanner sc){
        String titolo, autore, album;
        if(!sc.hasNext()) return null;
        titolo=sc.nextLine();
        if(!sc.hasNext()) return null;
        autore=sc.nextLine();
        if(!sc.hasNext()) return null;
        album=sc.nextLine();
        if(!sc.hasNext()) return null;
        sc.nextLine();

        return new Canzone(titolo, autore, album);
    }

    private String titolo;
    private String autore;
    private String album;
}