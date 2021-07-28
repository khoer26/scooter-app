package com.skuter;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public Main(){
        JFrame frame = new JFrame();
        frame.setTitle("E-Scooter");
        JLabel label = new JLabel("E-Scooter");
        label.setBounds(120, 20, 150, 30);
        JButton button1 = new JButton("Masuk");
        JButton button2 = new JButton("Daftar");
        button1.setBounds(100, 70, 100, 30);
        button2.setBounds(100, 110, 100, 30);

        frame.setLayout(null);
        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new login_2b();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new daftar_2a();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }
}