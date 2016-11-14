import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.Random;


public class NoListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        Random rand = new Random();
        String str[] = {"Hai condannato la tua gente alla miseria", "Populista di sto c@zzo", "L'apocalisse è vicina"};
       JOptionPane.showMessageDialog(null, str[rand.nextInt(3)]);
    }
}