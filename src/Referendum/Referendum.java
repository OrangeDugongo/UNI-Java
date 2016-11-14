import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;

public class Referendum {
    public static void main(String [] args) throws Exception{
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;
        Scanner sc = new Scanner(new File("Quesito.txt"));
        JPanel quesito = new JPanel();
        quesito.setLayout(new GridLayout(8,1));
        JPanel voto = new JPanel();
        voto.setLayout(new GridLayout(1,2));
        JPanel scheda = new JPanel();
        scheda.setLayout(new BorderLayout());
        JFrame frame = new JFrame();
        JButton si = new JButton("SI");
        JButton no = new JButton("NO");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Quesito referendario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel label1 = new JLabel("«"+sc.nextLine());
        JLabel label2 = new JLabel(sc.nextLine());
        JLabel label3 = new JLabel(sc.nextLine());
        JLabel label4 = new JLabel(sc.nextLine());
        JLabel label5 = new JLabel(sc.nextLine());
        JLabel label6 = new JLabel(sc.nextLine());
        JLabel label7 = new JLabel(sc.nextLine());
        JLabel label8 = new JLabel(sc.nextLine()+"»");
        quesito.add(label1);
        quesito.add(label2);
        quesito.add(label3);
        quesito.add(label4);
        quesito.add(label5);
        quesito.add(label6);
        quesito.add(label7);
        quesito.add(label8);
        voto.add(si);
        voto.add(no);
        scheda.add(quesito, BorderLayout.NORTH);
        scheda.add(voto, BorderLayout.SOUTH);
        frame.add(scheda);

        ActionListener listener = new SiListener();
        si.addActionListener(listener);
    }
}
