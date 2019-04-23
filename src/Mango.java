import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Mango extends JPanel {

    Ufo p1;
    Egg e1;
    Random r = new Random();
    int[] ufoP = r.ints(r.nextInt(5),333,555).toArray();
    Mango(){
        p1 = new Ufo(ufoP,ufoP,Color.YELLOW);
        e1 = new Egg(Color.CYAN,400,500,30,30);
        }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        p1.drawMe(g);
        e1.drawMe(g);
    }



}
