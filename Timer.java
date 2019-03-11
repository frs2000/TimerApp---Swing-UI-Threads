package time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer {
    public static void main(String[] args) {
        JFrame myTaymer = new JFrame("Timer") ;
        myTaymer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myTaymer.setSize(400, 300);


        JPanel pan1 = new JPanel();
        myTaymer.getContentPane().add(pan1);
        pan1.setLayout(new GridLayout(4,4));


        JTextField  btnMin = new JTextField ("0");
        JTextField  btnSec = new JTextField ("0");
        btnMin.setHorizontalAlignment(SwingConstants.CENTER);
        btnSec.setHorizontalAlignment(SwingConstants.CENTER);
        btnMin.setFont(new Font("Serif", Font.BOLD, 32));
        btnSec.setFont(new Font("Serif", Font.BOLD, 32));

        //btnMin.setForeground(Color.GREEN);


        Thread myThread = new Thread() {
            int i = 0;

            @Override
            public void run (){
                while(!Thread.currentThread().isInterrupted()){
                    btnMin.setText(Integer.toString(i/60));
                    btnSec.setText(Integer.toString(i%60));
                    i = i+1;

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };


        ActionListener btnStart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myThread.start();
            }
        };

        ActionListener btnStop = new ActionListener() {
            int i = 0 ;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 1) {
                    btnMin.setText("0");
                    btnSec.setText("0");
                    i = 0 ;
                }
                if (i == 0)  {
                    myThread.interrupt();
                    ++i ;
                }
            }
        };

        JButton btn1 = new JButton("");
        JButton btn2 = new JButton("");
        JButton btn3 = new JButton("");
        JButton btn4 = new JButton("");
        JButton btn5 = new JButton("");

        JButton btn8 = new JButton("");
        JButton btn9 = new JButton("");
        JButton btn10 = new JButton("");
        JButton btn11 = new JButton("");
        JButton btn12 = new JButton("");
        JButton btn13 = new JButton("");
        JButton btn14 = new JButton("Stop/Clear");
        JButton btn15 = new JButton("Start");
        JButton btn16 = new JButton("");
        pan1.add(btn1);
        pan1.add(btn2);
        pan1.add(btn3);
        pan1.add(btn4);
        pan1.add(btn5);
        pan1.add(btnMin);
        pan1.add(btnSec);
        pan1.add(btn8);
        pan1.add(btn9);
        pan1.add(btn10);
        pan1.add(btn11);
        pan1.add(btn12);
        pan1.add(btn13);
        pan1.add(btn14);
        pan1.add(btn15);
        pan1.add(btn16);

        btn15.addActionListener(btnStart);
        btn14.addActionListener(btnStop);



        myTaymer.setVisible(true);
    }
}