import java.util.Scanner;
import java.io.PrintStream;

public class Albergo{

    public Albergo(String nome, double prezzo, boolean tv, boolean aria, boolean frigo, boolean internet){
        this.nome=nome;
        this.prezzo=prezzo;
        this.tv=tv;
        this.frigo=frigo;
        this.internet=internet;
        this.aria=aria;
    }

    public String getNome(){
        return nome;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public boolean hasTV(){
        return tv;
    }

    public boolean hasFrigo(){
        return frigo;
    }

    public boolean hasInternet(){
        return internet;
    }

    public boolean hasAria(){
        return aria;
    }

    public static Albergo read(Scanner sc){
        String nome;
        double prezzo;
        boolean tv, frigo, internet, aria;

        if(!sc.hasNextLine()) return null;
        nome=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        prezzo=Double.parseDouble(sc.nextLine());
        if(!sc.hasNextLine()) return null;
        tv=sc.nextLine().equalsIgnoreCase("SI");
        if(!sc.hasNextLine()) return null;
        aria=sc.nextLine().equalsIgnoreCase("SI");
        if(!sc.hasNextLine()) return null;
        frigo=sc.nextLine().equalsIgnoreCase("SI");
        if(!sc.hasNextLine()) return null;
        internet=sc.nextLine().equalsIgnoreCase("SI");

        return new Albergo(nome, prezzo, tv, aria, frigo, internet);
    }

    public void print(PrintStream ps){
        String boole;
        ps.println(nome);
        ps.println(prezzo);
        boole=tv?"SI":"NO";
        ps.println(boole);
        boole=aria?"SI":"NO";
        ps.println(boole);
        boole=frigo?"SI":"NO";
        ps.println(boole);
        boole=internet?"SI":"NO";
        ps.println(boole);
    }

    private String nome;
    private double prezzo;
    private boolean tv;
    private boolean frigo;
    private boolean internet;
    private boolean aria;
}