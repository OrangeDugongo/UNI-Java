/*
    Scrivere un programma che visualizzi in sequenza due panel per chiedere il
    nome di una persona e darle il benvenuto
*/
import javax.swing.JOptionPane;

public class Esercizio1{
    public static void main(String [] args){
        String name = JOptionPane.showInputDialog("Come ti chiami?");
        JOptionPane.showMessageDialog(null, "Salve "+name);

        System.exit(0);
    }
}
