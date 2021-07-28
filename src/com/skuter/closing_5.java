package com.skuter;

import java.awt.event.*;
import javax.swing.*;

public class closing_5 {

    public closing_5(){
        JFrame frame = new JFrame();

        frame.setTitle("E-Scooter");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        JLabel label1 = new JLabel("Penyewaan Scooter Telah Berhasil!");
        frame.setLayout(null);
        JLabel label2 = new JLabel("Have a nice riding! :)");
        frame.setLayout(null);
        frame.add(label1);
        frame.add(label2);
        frame.setResizable(false);
        label1.setBounds(45, 20, 250, 30);
        label2.setBounds(90, 50, 150, 30);
        JButton button1 = new JButton("OK");
        frame.add(button1);
        button1.setBounds(110, 100, 80, 30);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    public static void main(String[] args){
        new closing_5();
    }
}
