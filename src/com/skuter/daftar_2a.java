package com.skuter;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class daftar_2a {
    Connection konek = null;
    String url = "jdbc:mysql://remotemysql.com:3306/";
    String dbName = "yJKoEjfCCy";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "yJKoEjfCCy";
    String password = "i0IRpyy3IQ";
    static ResultSet res;
    static Statement st;
    static String query;

    JFrame f = new JFrame("Daftar Akun");
    JLabel lb1 = new JLabel("Daftar Akun");
    JLabel lb2 = new JLabel("Nama          : ");
    JLabel lb3 = new JLabel("NIM              : ");
    JLabel lb4 = new JLabel("No.Telp       : ");
    JLabel lb5 = new JLabel("Jurusan     : ");
    JLabel lb6 = new JLabel("Prodi           : ");
    JLabel lb7 = new JLabel("Password   :");

    JTextField f1 = new JTextField();
    JTextField f2 = new JTextField();
    JTextField f3 = new JTextField();
    JTextField f4 = new JPasswordField();

    String blank[]={""};
    String jurusan[]={"Teknik Sipil","Teknik Mesin","Teknik Refrigasi dan Tata Udara",
            "Teknik Konversi Energi","Teknik Elektro","Teknik Kimia","Bahasa Inggris",
            "Teknik Komputer dan Informatika","Akutansi","Administrasi Niaga"};
    String prodi[]={"D3 Teknik Konstruksi Gedung","D3 Teknik Konstruksi Sipil",
            "D4 Teknik Perancangan Jalan dan Jembatan","D4 Teknik Perawatan dan Perbaikan Gedung"};
    String prodi1[]={"D3 Teknik Mesin","D3 Teknik Aeronautika","D4 Teknik Perancangan dan Konstruksi Mesin",
            "D4 Proses Manufaktur"};
    String prodi2[]={"D3 Teknik Pendingin dan Tata Udara","D4 Teknik Pendingin dan Tata Udara"};
    String prodi3[]={"D3 Teknik Konversi Energi","D4 Teknologi Pembangkit Tenaga Listrik","D4 Teknik Konservasi Energi"};
    String prodi4[]={"D3 Teknik Elektronika","D3 Teknik Listrik","D3 Teknik Telekomunikasi","D4 Teknik Elektronika",
            "D4 Teknik Telekomunikasi","D4 Teknik Otomasi Industri"};
    String prodi5[]={"D3 Teknik Kimia","D3 Analis Kimia","D4 Teknik Kimia Produksi Bersih"};
    String prodi6[]={"D3 Bahasa Inggris"};
    String prodi7[]={"D3 Teknik Informatika","D4 Teknik Informatika"};
    String prodi8[]={"D3 Akutansi","D3 Keuangan dan Perbankan","D4 Akutansi Manajemen Pemerintahan",
            "D4 Keuangan Syariah","D4 Akutansi"};
    String prodi9[]={"D3 Administrasi Bisnis","D3 Manajemen Pemasaran","D3 Usaha Perjalanan Wisata",
            "D4 Manajemen Pemasaran","D4 Administrasi Bisnis"};
    String pilihan[]={"","","","","","","","",""};

    JComboBox cb=new JComboBox(jurusan);
    JComboBox combo=new JComboBox(blank);

    JComboBox cb0=new JComboBox(prodi);
    JComboBox cb1=new JComboBox(prodi1);
    JComboBox cb2=new JComboBox(prodi2);
    JComboBox cb3=new JComboBox(prodi3);
    JComboBox cb4=new JComboBox(prodi4);
    JComboBox cb5=new JComboBox(prodi5);
    JComboBox cb6=new JComboBox(prodi6);
    JComboBox cb7=new JComboBox(prodi7);
    JComboBox cb8=new JComboBox(prodi8);
    JComboBox cb9=new JComboBox(prodi9);

    JButton bt1 = new JButton("Daftar");

    String nama,nim,telp,jrsn,prdi,pass,a;

    public daftar_2a(){
        lb1.setBounds(150,10,150,20);
        lb2.setBounds(10,40,150,20);
        f1.setBounds(110,40,150,20);
        lb3.setBounds(10,70,150,20);
        f2.setBounds(110,70,150,20);
        lb4.setBounds(10,100,150,20);
        f3.setBounds(110,100,150,20);
        lb5.setBounds(10,130,150,20);
        cb.setBounds(110,130,250,20);
        lb6.setBounds(10,160,150,20);
        combo.setBounds(110,160,250,20);
        cb0.setBounds(110,160,250,20);
        cb1.setBounds(110,160,250,20);
        cb2.setBounds(110,160,250,20);
        cb3.setBounds(110,160,250,20);
        cb4.setBounds(110,160,250,20);
        cb5.setBounds(110,160,250,20);
        cb6.setBounds(110,160,250,20);
        cb7.setBounds(110,160,250,20);
        cb8.setBounds(110,160,250,20);
        cb9.setBounds(110,160,250,20);
        lb7.setBounds(10,190,150,20);
        f4.setBounds(110,190,150,20);
        bt1.setBounds(150,240,100,20);

        try{
            Class.forName(driver).newInstance();
            konek = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Koneksi Berhasil");
        }
        catch (Exception e){
            System.err.println("Error (1) : " + e);
            System.exit(1);
        }

        cb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                a=(String)cb.getSelectedItem();
                if (a=="Teknik Sipil"){
                    f.remove(combo);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb0);
                }
                if (a=="Teknik Mesin"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb1);
                }
                if (a=="Teknik Refrigasi dan Tata Udara"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb2);
                }
                if (a=="Teknik Konversi Energi"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb3);
                }
                if (a=="Teknik Elektro"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb4);
                }
                if (a=="Teknik Kimia"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb5);
                }
                if (a=="Bahasa Inggris"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb6);
                }
                if (a=="Teknik Komputer dan Informatika"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb8);
                    f.remove(cb9);
                    f.add(cb7);
                }
                if (a=="Akutansi"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb9);
                    f.add(cb8);
                }
                if (a=="Administrasi Niaga"){
                    f.remove(combo);
                    f.remove(cb0);
                    f.remove(cb1);
                    f.remove(cb2);
                    f.remove(cb3);
                    f.remove(cb4);
                    f.remove(cb5);
                    f.remove(cb6);
                    f.remove(cb7);
                    f.remove(cb8);
                    f.add(cb9);
                }
            }
        });
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nama=f1.getText();
                nim=f2.getText();
                telp=f3.getText();
                jrsn=(String)cb.getSelectedItem();
                if (a=="Teknik Sipil") prdi=(String)cb0.getSelectedItem();
                if (a=="Teknik Mesin") prdi=(String)cb1.getSelectedItem();
                if (a=="Teknik Refrigasi dan Tata Udara") prdi=(String)cb2.getSelectedItem();
                if (a=="Teknik Konversi Energi") prdi=(String)cb3.getSelectedItem();
                if (a=="Teknik Elektro") prdi=(String)cb4.getSelectedItem();
                if (a=="Teknik Kimia") prdi=(String)cb5.getSelectedItem();
                if (a=="Bahasa Inggris") prdi=(String)cb6.getSelectedItem();
                if (a=="Teknik Komputer dan Informatika") prdi=(String)cb7.getSelectedItem();
                if (a=="Akutansi") prdi=(String)cb8.getSelectedItem();
                if (a=="Administrasi Niaga") prdi=(String)cb9.getSelectedItem();
                pass=f4.getText();
                try{
                    st = konek.createStatement();
                    st.executeUpdate("Insert into costumer values (NULL,'"+nama+"','"+telp+"','"+jrsn+"','"+prdi+"','"+nim+"','"+pass+"',NULL)");
                }
                catch (Exception f){
                    System.err.println("error(2): "+f);
                    System.exit(1);
                }
                new login_2b();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        });

        f.add(lb1);f.add(lb2);f.add(lb3);f.add(lb4);
        f.add(lb5);f.add(lb6);f.add(lb7);f.add(bt1);
        f.add(f1);f.add(f2);f.add(f3);f.add(f4);
        f.add(cb);f.add(combo);

        f.setLayout(null);
        f.setSize(430,350);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
    }
    public static void main(String[] args) {
        new daftar_2a();
    }
}
