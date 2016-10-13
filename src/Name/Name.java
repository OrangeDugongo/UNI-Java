/**
    La classe Name rappresenta il nome di una persona.
    include il nome, il cognome e il titolo della persona.
*/

public class Name{

    /**
        Inizializza una persona settando tutti i suo parametri come vuoti
    */
    public Name(){
        name="";
        cname="";
        titolo="";
    }

    /**
        Inizializza una persona.
        @param n nome della persona
        @param c cognome della persona
    */
    public Name(String n, String c){
        name=n;
        cname=c;
        titolo="";
    }

    /**
        Inizializza una persona.
        @param n nome della persona
        @param c cognome della persona
        @param t titolo della persona
    */
    public Name(String n, String c, String t){
        name=n;
        cname=c;
        titolo=t;
    }

    /**
        @return Una stringa con le le iniziali
    */
    public String iniziali(){
        return name.substring(0, 1).concat(". ").concat(cname.substring(0,1)).concat(".");
    }

    /**
        @return Una stringa con il nome e cognome
    */
    public String nomeCognome(){
        return name.concat(" ").concat(cname);
    }

    /**
        @return Una stringa con il titolo, il cognome e il nome
    */
    public String title(){
        return titolo.concat(" ").concat(cname).concat(" ").concat(name);
    }

    /**
        @param Nuovo titolo
    */
    public void setTitolo(String t){
        titolo=t;
    }

    private String name;
    private String cname;
    private String titolo;
}
