package com.skuter;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class detail_transaksi_4 {
    Connection konek = null;
    String url = "jdbc:mysql://remotemysql.com:3306/";
    String dbName = "yJKoEjfCCy";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "yJKoEjfCCy";
    String password = "i0IRpyy3IQ";
    static ResultSet res;
    static Statement st;
    static String query;

    String tgl,wkt;
    int idtrs;

    JFrame f = new JFrame("Detail Transaksi");
    JLabel lb1 = new JLabel("Detail Transaksi");
    JLabel lb2 = new JLabel("ID_Transaksi                    : ");
    JLabel lb3 = new JLabel("Nomor scooter                 : ");
    JLabel lb4 = new JLabel("Tanggal Penyewaan       : ");
    JLabel lb5 = new JLabel("Waktu Penyewaan          : ");
    JLabel lb6 = new JLabel("Durasi Penyewaan          : ");
    JLabel lb7 = new JLabel("Harga                                  :");
    JLabel lb8 = new JLabel();
    JLabel lb9 = new JLabel();
    JLabel lb10 = new JLabel();
    JLabel lb11 = new JLabel ();
    JLabel lb12 = new JLabel ();
    JLabel lb13 = new JLabel ();

    JButton bt1 = new JButton("Setuju");
    public detail_transaksi_4(){
        lb1.setBounds(150,10,150,20);
        lb2.setBounds(10,40,150,20);
        lb3.setBounds(10,70,150,20);
        lb4.setBounds(10,100,150,20);
        lb5.setBounds(10,130,150,20);
        lb6.setBounds(10,160,150,20);
        lb7.setBounds(10,190,150,20);

        lb8.setBounds(170,40,150,20);
        lb9.setBounds(170,70,150,20);
        lb10.setBounds(170,100,150,20);
        lb11.setBounds(170,130,150,20);
        lb12.setBounds(170,160,150,20);
        lb13.setBounds(170,190,150,20);
        bt1.setBounds(150,240,100,20);

        try{
            Class.forName(driver);
            konek = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Koneksi Berhasil");
        }
        catch (Exception e){
            System.err.println("Error (1) : " + e);
            System.exit(1);
        }

        try {
            st = konek.createStatement();
            res = st.executeQuery("select * from transaksi;");
            while(res.next()){
                idtrs=res.getInt("ID_Transaksi");
            }
        }
        catch(Exception f) {
            System.out.println("Error (1) : " + f);
        }

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tgl = java.time.LocalDate.now().format(date);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        wkt = java.time.LocalTime.now().format(time);

        lb8.setText(String.valueOf(idtrs+1));
        lb9.setText(penyewaan_3.no_sktr);
        lb10.setText(tgl);
        lb11.setText(wkt);
        lb12.setText(penyewaan_3.drs+" menit");
        lb13.setText(String.valueOf("Rp. "+penyewaan_3.harga));

        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    st = konek.createStatement();
                    st.executeUpdate("Insert into transaksi values (NULL,'"+login_2b.ID_cstmr+"','"+penyewaan_3.no_sktr+"','"+wkt+"','"+tgl+"','"+penyewaan_3.drs+" menit"+"','"+penyewaan_3.harga+"')");
                }
                catch (Exception f){
                    System.err.println("error(2): "+f);
                    System.exit(1);
                }
                int saldo=penyewaan_3.Saldo-penyewaan_3.harga;
                try{
                    st=konek.createStatement();
                    st.executeUpdate("update costumer set Saldo='"+saldo+"' where ID_Costumer="+login_2b.ID_cstmr);
                }
                catch(Exception f){
                    System.err.println("error(5): "+f);
                }
                try{
                    st=konek.createStatement();
                    st.executeUpdate("update scooter set Status='"+"Tidak Tersedia"+"' where ID_Scooter="+penyewaan_3.no_sktr);
                }
                catch(Exception f){
                    System.err.println("error(5): "+f);
                }
                new closing_5();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        });

        f.add(lb1);f.add(lb2);f.add(lb3);f.add(lb4);
        f.add(lb5);f.add(lb6);f.add(lb7);f.add(lb8);
        f.add(lb9);f.add(lb10);f.add(lb11);f.add(lb12);
        f.add(lb13);f.add(bt1);

        f.setLayout(null);
        f.setSize(430,350);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

    }
    public static void main(String[] args) {
        new detail_transaksi_4();
    }
}