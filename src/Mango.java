import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;


public class Mango extends JPanel {

    Ufo p1;
    Egg e1;
    boolean takCzyNie = false;
    String botonText = "start";


    private java.util.List<Object> daLizt = new ArrayList<>();

    Random r = new Random();
    Timer sgtimer = new Timer(1000,new SantiAction());

    Mango(){}

    public void queHago(){
        if(takCzyNie){
            takCzyNie = false;
        }else{
            takCzyNie = true;
        }
    }

    public void messItUp(){
        if(takCzyNie){
            sgtimer.start();
            botonText = "stop";
        }else{
            sgtimer.stop();
            botonText = "start";
        }
    }

    public void saveToFile() throws IOException {
        takCzyNie = false;
        messItUp();
        BufferedWriter writer = new BufferedWriter(new FileWriter("esteEsElGUIoutput.txt"));
        for(Object mierda:daLizt){
            writer.write(mierda.toString()+"\n");
        }

        writer.close();
    }

    public void readAndDraw(){
        this.removeAll();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "esteEsElGUIoutput.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] array = line.split("\\,", -1);
                if(line.contains("java")){
                    Egg a = new Egg(cebula(),parseInt(array[3]),parseInt(array[4]),parseInt(array[5]));
                    daLizt.add(a);
                }else{
                    System.out.println("Polygon busy, try again later :)");
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        for(Object mierda:daLizt){
            if(mierda instanceof Ufo){
                ((Ufo)mierda).drawMe(g);
            }
            if(mierda instanceof Egg){
                ((Egg)mierda).drawMe(g);
            }
//            if(mierda instanceof Ufo){
//                ((Ufo)mierda).drawMe(g);
//            }
        }
    }

    public int nume(int max, int min) {
        return r.nextInt((max - min)+1)+min;
    }

    public int nume() {
        return r.nextInt((350 - 50) + 1)+50;
    }

    public Color cebula(){
        return new Color(nume(255,0),nume(255,0),nume(255,0));
    }

    public Egg newEgg(){
        Egg n = new Egg(cebula(),nume(600,200),nume(),nume());
        System.out.println(n.toString());
        return n;
    }

    public Ufo newUfo(){
        Ufo n = new Ufo(new int[]{nume(), nume(), nume(),nume(),nume()}, new int[]{nume(), nume(), nume(),nume(),nume()},cebula() );
        System.out.println(n.toString());
        return n;

    }


    class SantiAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            daLizt.add(newEgg());
            daLizt.add(newUfo());
            repaint();
        }
    }
}
