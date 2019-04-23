import javax.swing.*;
import java.awt.*;


public class Monkey {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Hi");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Mango m = new Mango();
                m.setBackground(Color.BLACK);
                frame.add(m);
                frame.setSize(900,900);
                frame.setVisible(true);
            }
        });


    }
}

