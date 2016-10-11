import javax.swing.JOptionPane;

public class Ese2{
    public static void main(String [] args){
        String name = JOptionPane.showInputDialog("Come ti chiami?");
        System.out.print("Ciao, ");
        System.out.print(name);
        System.out.print("!");
        System.exit(0);
    }
}
