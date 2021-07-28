package com.skuter;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class penyewaan_3 {
    Connection konek = null;
    String url = "jdbc:mysql://remotemysql.com:3306/";
    String dbName = "yJKoEjfCCy";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "yJKoEjfCCy";
    String password = "i0IRpyy3IQ";
    static ResultSet res;
    static Statement st;
    static String query;

    static String no_sktr,drs;
    static int harga,Saldo;
    String wrn,gdg,lksi,sldo,warna;
    int Durasi;
    boolean x,y;

    JFrame f;
    public penyewaan_3() {
        f = new JFrame("E-Scooter");
        final JLabel label = new JLabel("Penyewaan E-Scooter");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,50);
        JLabel welcome = new JLabel("Selamat Datang "+login_2b.nama);
        welcome.setBounds(136,35,200,30);

        JLabel saldo = new JLabel();
        saldo.setBounds(50,70,200,20);
        JLabel lbl1 = new JLabel("Lokasi Gedung");
        lbl1.setBounds(50, 100, 100, 20);
        JLabel lbl2 = new JLabel("Warna Scooter");
        lbl2.setBounds(50, 150, 100, 20);
        JLabel lbl3 = new JLabel("Durasi penyewaan");
        lbl3.setBounds(50, 200, 125, 20);
        JLabel lbl4 = new JLabel("Harga sewa : Rp. 3000,00 / 5 menit");
        lbl4.setBounds(50, 250, 400, 20);
        JButton b=new JButton("Sewa");
        b.setBounds(150,300,100,30);

        String gedung[]={"Gedung A","Gedung B","Gedung C","Gedung D","Gedung E","Gedung F","Gedung G","Gedung H"};
        final JComboBox combo1 = new JComboBox(gedung);
        combo1.setBounds(250,100,100,20);

        String blank[]={""};
        JComboBox cb=new JComboBox(blank);
        cb.setBounds(250,150,100,20);

        String warna1[]={"Biru","Pink"};
        final JComboBox cb1 = new JComboBox(warna1);
        cb1.setBounds(250,150,100,20);

        String warna2[]={"Biru"};
        final JComboBox cb2 = new JComboBox(warna2);
        cb2.setBounds(250,150,100,20);

        String warna3[]={"Pink"};
        final JComboBox cb3 = new JComboBox(warna3);
        cb3.setBounds(250,150,100,20);


        String durasi[]={"5","10","15","20","25","30","45","50","55","60"};
        final JComboBox combo2 = new JComboBox(durasi);
        combo2.setBounds(250,200,100,20);

        try{
            Class.forName(driver).newInstance();
            konek = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Koneksi Berhasil");
        }
        catch (Exception e){
            System.err.println("Error (1) : " + e);
            System.exit(1);
        }

        try {
            st = konek.createStatement();
            res = st.executeQuery("select * from costumer where ID_Costumer="+login_2b.ID_cstmr+";");
            res.next();
            sldo=res.getString("Saldo");
            Saldo = Integer.parseInt(sldo);

        }
        catch(Exception f){
            System.out.println("Error (1) : " + f);
        }
        saldo.setText("Sisa saldo = "+sldo);

        combo1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gdg=(String)combo1.getSelectedItem();
                if (gdg=="Gedung A") lksi="1";
                if (gdg=="Gedung B") lksi="2";
                if (gdg=="Gedung C") lksi="3";
                if (gdg=="Gedung D") lksi="4";
                if (gdg=="Gedung E") lksi="5";
                if (gdg=="Gedung F") lksi="6";
                if (gdg=="Gedung G") lksi="7";
                if (gdg=="Gedung H") lksi="8";
                    try {
                        st = konek.createStatement();
                        res = st.executeQuery("select * from scooter where ID_Lokasi='"+lksi+"' AND Status='Tersedia';");
                        while(res.next()){
                            wrn=res.getString("Warna");
                            if (wrn.equals("Biru")) x=true;
                            if (wrn.equals("Pink")) y=true;
                        }
                    }
                    catch(Exception f){
                        System.out.println("Error (1) : " + f);
                    }
                if (x==false && y==false){
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.add(cb);
                    JOptionPane.showMessageDialog(null, "Mohon maaf scooter di tempat ini kosong.");
                }
                if (x==false && y==true){
                    f.remove(cb);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.add(cb3);
                    cb3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            try {
                                warna=(String)cb3.getSelectedItem();
                                st = konek.createStatement();
                                res = st.executeQuery("select * from scooter where Warna='"+warna+"' AND ID_Lokasi='"+lksi+"';");
                                res.next();
                                no_sktr = res.getString("ID_Scooter");
                            }
                            catch (Exception g) {
                                System.out.println("Error (1) : " + g);
                            }
                        }
                    });
                }
                if (x==true && y==false){
                    f.remove(cb);
                    f.remove(cb1);
                    f.remove(cb3);
                    f.add(cb2);
                    cb2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            try {
                                warna=(String)cb2.getSelectedItem();
                                st = konek.createStatement();
                                res = st.executeQuery("select * from scooter where Warna='"+warna+"' AND ID_Lokasi='"+lksi+"';");
                                res.next();
                                no_sktr = res.getString("ID_Scooter");
                            }
                            catch (Exception g) {
                                System.out.println("Error (1) : " + g);
                            }
                        }
                    });
                }
                if (x==true && y==true){
                    f.remove(cb);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.add(cb1);
                    cb1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            try {
                                warna=(String)cb1.getSelectedItem();
                                st = konek.createStatement();
                                res = st.executeQuery("select * from scooter where Warna='"+warna+"' AND ID_Lokasi='"+lksi+"';");
                                res.next();
                                no_sktr = res.getString("ID_Scooter");
                            }
                            catch (Exception g) {
                                System.out.println("Error (1) : " + g);
                            }
                        }
                    });
                }
                x=false;
                y=false;
            }
        });

        combo2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drs=(String)combo2.getSelectedItem();
                Durasi=Integer.parseInt(drs);
                harga=Durasi*3000/5;
            }
        });


        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (Saldo<harga){
                    JOptionPane.showMessageDialog(null, "Mohon maaf saldo anda tidak cukup.");
                }
                else {
                    new detail_transaksi_4();
                    f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        f.add(combo1);f.add(combo2);f.add(b); f.add(label);f.add(lbl1);f.add(lbl2);f.add(lbl3);f.add(lbl4);f.add(saldo);f.add(welcome);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        new penyewaan_3();
    }
}