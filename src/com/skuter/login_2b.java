package com.skuter;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login_2b{
     Connection konek = null;
     String url = "jdbc:mysql://remotemysql.com:3306/";
     String dbName = "yJKoEjfCCy";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "yJKoEjfCCy";
     String password = "i0IRpyy3IQ";
     static ResultSet res;
     static Statement st;
     static String query;
     static String ID_cstmr,pass,nama;

     JFrame frame = new JFrame("Menu Login Sederhana");
     JLabel lblNIM = new JLabel("NIM");
     JLabel lblPasswd = new JLabel("Password");
     JTextField txtNIM = new JTextField();
     JPasswordField txtPasswd = new JPasswordField();
     JButton btnMasuk = new JButton("Masuk");
     int count = 0;

     public login_2b(){

        lblNIM.setBounds(20, 20, 100, 20);
        lblPasswd.setBounds(20, 50, 100, 20);
        txtNIM.setBounds(100, 20, 130, 20);
        txtPasswd.setBounds(100, 50, 130, 20);
        btnMasuk.setBounds(20, 80, 75, 20);

         try{
             Class.forName(driver).newInstance();
             konek = DriverManager.getConnection(url+dbName,userName,password);
             System.out.println("Koneksi Berhasil");
         }
         catch (Exception e){
             System.err.println("Error (1) : " + e);
             System.exit(1);
         }

        btnMasuk.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String nim = txtNIM.getText().toString();
                 String passwd = txtPasswd.getText().toString();
                 try{
                     st=konek.createStatement();
                     res = st.executeQuery("select * from costumer where NIM='"+nim+"' ;");
                     res.next();
                     pass =res.getString("Password");

                     if(passwd.equals(pass)) {
                         JOptionPane.showMessageDialog(null, "Anda berhasil login");
                         ID_cstmr=res.getString("ID_Costumer");
                         nama=res.getString("Nama");
                         new penyewaan_3();
                         frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                         }
                     else {
                         JOptionPane.showMessageDialog(null, "Password Anda salah!!!");
                         count++;
                         if(count == 3) {
                             JOptionPane.showMessageDialog(null, "Anda sudah gagal Login sebanyak 3 kali. Harap coba lagi nanti.");
                             System.exit(1);
                         }
                     }
                 }
                 catch(Exception f){
                     JOptionPane.showMessageDialog(null, "Username dan Password Anda salah!!!");
                     count++;
                     if(count == 3) {
                         JOptionPane.showMessageDialog(null, "Anda sudah gagal Login sebanyak 3 kali. Harap coba lagi nanti.");
                         System.exit(1);
                     }
                 }
             }
         });

         frame.add(lblNIM);
         frame.add(lblPasswd);
         frame.add(txtNIM);
         frame.add(txtPasswd);
         frame.add(btnMasuk);
         frame.setLayout(null);
         frame.setSize(250, 150);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         frame.setResizable(false);
    }
    public static void main(String[] args){
         new login_2b();
    }
}
