import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.Random;

public class SiListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        Random rand = new Random();
        String str[] = {"Grazie per aver venduto la sovranità popolare", "Radical chic di sto c@zzo", "Sei appena entrato in dittatura"};
       JOptionPane.showMessageDialog(null, str[rand.nextInt(3)]);    
    }
}