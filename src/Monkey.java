import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Monkey {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Hi");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Mango m = new Mango();
                m.setBackground(Color.BLACK);
                JButton startButton = new JButton("Start");
                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        m.queHago();
                        m.messItUp();
                        startButton.setText(m.botonText);
                    }
                });

                JButton apagueYvamonos = new JButton("Save Canvas");
                apagueYvamonos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            m.saveToFile();
                        }catch (IOException ex){
                            System.out.println(ex);
                        }

                    }
                });
                JButton readAndDraw = new JButton("Read & Draw");
                readAndDraw.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        m.readAndDraw();
                    }
                });
                frame.setLayout(new BorderLayout());
                frame.add(m, BorderLayout.CENTER);
                frame.add(startButton, BorderLayout.SOUTH);
                frame.add(apagueYvamonos, BorderLayout.BEFORE_LINE_BEGINS);
                frame.add(readAndDraw, BorderLayout.BEFORE_FIRST_LINE);

                frame.setSize(1300,800);
                frame.setVisible(true);
            }
        });


    }
}

