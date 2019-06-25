/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project19;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author choi5
 */
public class Home19 extends JFrame {

    /**
     * Creates new form Home19
     */
    public Home19() throws ParserConfigurationException, SAXException, IOException {
        initComponents();
        ViewPanel.setVisible(false);
        cold hun = new cold();
        jLabel13.setText(hun.cold_parasing());
    }

     public void HospitalData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//db파일불러오기.
            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.38.171:3309/bogam", "chatae", "354634");  // 아이피 수정해주기!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `hospital` WHERE 1");//수정하기 불러올 데이터 db이름으로

            ArrayList< Hospital> Hospitallist = new ArrayList< Hospital>();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Index", "병원분류", "주소", "이름", "전화번호"});//테이블이름.
            Object[] row = new Object[5];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

            for (int i = 0; i < Hospitallist.size(); i++) {
                row[0] = Hospitallist.get(i).getIdx();
                row[1] = Hospitallist.get(i).getLavel();
                row[2] = Hospitallist.get(i).getAddr();
                row[3] = Hospitallist.get(i).getName();
                row[4] = Hospitallist.get(i).getTel1();
                model.addRow(row);
            }

            jTable_Users.setModel(model);

            while (jTable_Users.getRowCount() > 0) {
                ((DefaultTableModel) jTable_Users.getModel()).removeRow(0);

            }
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[col];
                for (int i = 1; i <= col; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) jTable_Users.getModel()).insertRow(rs.getRow() - 1, rows);

            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("접속을 실패햇습니다.");
        }
    }

    public void PharmacyData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//db파일불러오기.
            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.38.171:3309/bogam", "chatae", "354634");  // 아이피 수정해주기!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `pharmacy` WHERE 1");//수정하기 불러올 데이터 db이름으로

            ArrayList< Pharmacy> Pharmacylist = new ArrayList< Pharmacy>();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Index", "주소", "이름", "주소요약", "전화번호", "Close", "Open"});//User(int Id, String Fname,String Lname,int Number) 부분 
            Object[] row = new Object[5];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

            for (int i = 0; i < Pharmacylist.size(); i++) {
                row[0] = Pharmacylist.get(i).getIdx();
                row[1] = Pharmacylist.get(i).getAddr();
                row[2] = Pharmacylist.get(i).getName();
                row[3] = Pharmacylist.get(i).getmapimg();
                row[4] = Pharmacylist.get(i).getTel1();
                row[5] = Pharmacylist.get(i).getClose();
                row[6] = Pharmacylist.get(i).getOpen();
                model.addRow(row);
            }

            jTable_Users.setModel(model);
            while (jTable_Users.getRowCount() > 0) {
                ((DefaultTableModel) jTable_Users.getModel()).removeRow(0);

            }
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[col];
                for (int i = 1; i <= col; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) jTable_Users.getModel()).insertRow(rs.getRow() - 1, rows);

            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("접속을 실패햇습니다.");
        }
    }

    public void EmergencyData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//db파일불러오기.
            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.38.171:3309/bogam", "chatae", "354634");  // 아이피 수정해주기!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `emergency` WHERE 1");//수정하기 불러올 데이터 db이름으로

            ArrayList< Emergency> list = new ArrayList< Emergency>();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Index", "주소", "이름", "전화번호1", "전화번호2"});//User(int Id, String Fname,String Lname,int Number) 부분 
            Object[] row = new Object[5];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getIdx();
                row[1] = list.get(i).getAddr();
                row[2] = list.get(i).getName();
                row[3] = list.get(i).getTel1();
                row[4] = list.get(i).getTel2();
                model.addRow(row);
            }

            jTable_Users.setModel(model);

            while (jTable_Users.getRowCount() > 0) {
                ((DefaultTableModel) jTable_Users.getModel()).removeRow(0);

            }
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[col];
                for (int i = 1; i <= col; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) jTable_Users.getModel()).insertRow(rs.getRow() - 1, rows);

            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("접속을 실패햇습니다.");
        }
    }

    public void EmergencyroomData() {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.38.171:3309/bogam", "chatae", "354634");  // 아이피 수정해주기!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `emergency_room` WHERE 1");//수정하기 불러올 데이터 db이름으로

            ArrayList< Emergencyroom>  Emergencyroomlist = new ArrayList<  Emergencyroom>();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"index", "이름", "전화번호", "응급실가용정보","입원실가용정보"});//User(int Id, String Fname,String Lname,int Number) 부분 
            Object[] row = new Object[6];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

            for (int i = 0; i <  Emergencyroomlist.size(); i++) {
                row[0] =  Emergencyroomlist.get(i).getIdx();
                row[1] =  Emergencyroomlist.get(i).getName();
                row[2] =  Emergencyroomlist.get(i).getTel1();
                row[3] =  Emergencyroomlist.get(i).getServiceable();
                row[5] =  Emergencyroomlist.get(i).getHospital();
                
                model.addRow(row);
            }

            jTable_Users.setModel(model);

            while (jTable_Users.getRowCount() > 0) {
                ((DefaultTableModel) jTable_Users.getModel()).removeRow(0);

            }
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[col];
                for (int i = 1; i <= col; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) jTable_Users.getModel()).insertRow(rs.getRow() - 1, rows);

            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("접속을 실패햇습니다.");
        }
    }

    
    
    


    
   
    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://172.17.38.171:3309/bogam", "chatae", "354634");// db에따라 수정

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

    public ArrayList<Hospital> HospitalListUsers(String ValToSearch) {//병원검색기능
        ArrayList<Hospital> HospitalusersList = new ArrayList<Hospital>();
        Statement st;
        ResultSet rs;
        try {

            Connection con = getConnection();
            System.out.println("검색서버 접속완료");
            st = con.createStatement();
            String searchQuery = "SELECT *FROM `hospital` WHERE CONCAT (idx,level,addr,name,tel1) LIKE '%" + ValToSearch + "%'"; // 이부분은 비트나미보고 수정 해야됨 위에 변수들도 마찬가지로.
            System.out.println("%" + ValToSearch + "%");
            rs = st.executeQuery(searchQuery);
            System.out.println("검색통과");

            Hospital user;
            System.out.println(ValToSearch);
            while (rs.next()) {
                System.out.println("찾는중입니다...");
                user = new Hospital(
                        rs.getString("idx"),
                        rs.getString("level"),
                        rs.getString("addr"),
                        rs.getString("name"),
                        rs.getString("tel1") // 여기도 db 에따라 수정
                );
                HospitalusersList.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("search 실패");
        }

        return HospitalusersList;
    }

    public ArrayList<Pharmacy> PharmacyListUsers(String ValToSearch) {  //  약국 검색기능
        ArrayList<Pharmacy> PharmacyusersList = new ArrayList<Pharmacy>();
        Statement st;
        ResultSet rs;
        try {

            Connection con = getConnection();
            System.out.println("검색서버 접속완료");
            st = con.createStatement();
            String searchQuery = "SELECT *FROM `pharmacy` WHERE CONCAT(idx,addr,name,Mapimg,tel1,close,open) LIKE '%" + ValToSearch + "%'"; // 이부분은 비트나미보고 수정 해야됨 위에 변수들도 마찬가지로.
            System.out.println("%" + ValToSearch + "%");
            rs = st.executeQuery(searchQuery);
            System.out.println("검색통과");
            Pharmacy user;
            System.out.println(ValToSearch);
            while (rs.next()) {
                System.out.println("찾는중입니다...");
                user = new Pharmacy(
                        rs.getString("idx"),
                        rs.getString("addr"),
                        rs.getString("name"),
                        rs.getString("Mapimg"),
                        rs.getString("tel1"),
                        rs.getString("close"),
                        rs.getString("open")// 여기도 db 에따라 수정
                );
                PharmacyusersList.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("search 실패");
        }

        return PharmacyusersList;
    }

    public ArrayList<Emergency> EmergencyListUsers(String ValToSearch) {  //  약국 검색기능
        ArrayList<Emergency> EmergencyusersList = new ArrayList<Emergency>();
        Statement st;
        ResultSet rs;
        try {

            Connection con = getConnection();
            System.out.println("검색서버 접속완료");
            st = con.createStatement();
            String searchQuery = "SELECT *FROM `emergency` WHERE CONCAT(idx,addr,name,tel1,tel2) LIKE '%" + ValToSearch + "%'"; // 이부분은 비트나미보고 수정 해야됨 위에 변수들도 마찬가지로.
            System.out.println("%" + ValToSearch + "%");
            rs = st.executeQuery(searchQuery);
            System.out.println("검색통과");
            Emergency user;
            System.out.println(ValToSearch);
            while (rs.next()) {
                System.out.println("찾는중입니다...");
                user = new Emergency(
                        rs.getString("idx"),
                        rs.getString("addr"),
                        rs.getString("name"),
                        rs.getString("tel1"),
                        rs.getString("tel2")
                );// 여기도 db 에따라 수정
                EmergencyusersList.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("search 실패");
        }

        return EmergencyusersList;
    }
    
    public ArrayList<Emergencyroom> EmergencyroomListUsers(String ValToSearch) {  //  약국 검색기능
        ArrayList<Emergencyroom> EmergencyroomusersList = new ArrayList<Emergencyroom>();
        Statement st;
        ResultSet rs;
        try {

            Connection con = getConnection();
            System.out.println("검색서버 접속완료");
            st = con.createStatement();
            String searchQuery = "SELECT *FROM `emergency_room` WHERE CONCAT(idx,name,serviceable,hospital) LIKE '%" + ValToSearch + "%'"; // 이부분은 비트나미보고 수정 해야됨 위에 변수들도 마찬가지로.
            System.out.println("%" + ValToSearch + "%");
            rs = st.executeQuery(searchQuery);
            System.out.println("검색통과");
             Emergencyroom user;
            System.out.println(ValToSearch);
            while (rs.next()) {
                System.out.println("찾는중입니다...");
                user = new Emergencyroom(
                        rs.getString("idx"),
                        rs.getString("name"),
                        rs.getString("tel1"),
                        rs.getString("serviceable"),
                        rs.getString("hospital")
                );// 여기도 db 에따라 수정
               EmergencyroomusersList.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("search 실패");
        }

        return EmergencyroomusersList;
    }

    public void HospitalfindUsers() {
        ArrayList<Hospital> users = HospitalListUsers(jText_Search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Index", "병원분류", "주소", "이름", "전화번호"});//User(int Id, String Fname,String Lname,int Number) 부분 
        Object[] row = new Object[5];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

        for (int i = 0; i < users.size(); i++) {
            System.out.println("갱신중입니다..");
            row[0] = users.get(i).getIdx();
            row[1] = users.get(i).getLavel();
            row[2] = users.get(i).getAddr();
            row[3] = users.get(i).getName();
            row[4] = users.get(i).getTel1();
            model.addRow(row);
        }

        jTable_Users.setModel(model);

    }

    public void PharmacyfindUsers() {
        ArrayList< Pharmacy> users = PharmacyListUsers(jText_Search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Index", "주소", "이름", "주소요약", "전화번호", "Close", "Open"});//User(int Id, String Fname,String Lname,int Number) 부분 
        Object[] row = new Object[7];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

        for (int i = 0; i < users.size(); i++) {
            System.out.println("갱신중입니다...");
            row[0] = users.get(i).getIdx();
            row[1] = users.get(i).getAddr();
            row[2] = users.get(i).getName();
            row[3] = users.get(i).getmapimg();
            row[4] = users.get(i).getTel1();
            row[5] = users.get(i).getClose();
            row[6] = users.get(i).getOpen();
            model.addRow(row);
        }

        jTable_Users.setModel(model);

    }

    public void EmergencyfindUsers() {
        ArrayList< Emergency> users = EmergencyListUsers(jText_Search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Index", "주소", "이름", "전화번호1", "전화번호2"});//User(int Id, String Fname,String Lname,int Number) 부분 
        Object[] row = new Object[5];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

        for (int i = 0; i < users.size(); i++) {
            System.out.println("갱신중입니다....");
            row[0] = users.get(i).getIdx();
            row[1] = users.get(i).getAddr();
            row[2] = users.get(i).getName();
            row[3] = users.get(i).getTel1();
            row[4] = users.get(i).getTel2();

            model.addRow(row);
        }

        jTable_Users.setModel(model);

    }
    
    public void EmergencroomyfindUsers() {
        ArrayList< Emergencyroom> users = EmergencyroomListUsers(jText_Search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"index", "이름", "전화번호", "응급실가용정보","입원실가용정보"});//User(int Id, String Fname,String Lname,int Number) 부분 
        Object[] row = new Object[4];// 테이블 마다 갯수가 다르니 이것도 db마다 수정

        for (int i = 0; i < users.size(); i++) {
            System.out.println("갱신중입니다....");
            row[0] = users.get(i).getIdx();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getServiceable();
            row[3] = users.get(i).getHospital();

            model.addRow(row);
        }

        jTable_Users.setModel(model);

    }

  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_hospital = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_drugstore = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_emergency = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_emergencyroom = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JPanel();
        jText_Search = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Users = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel24.setText("jLabel24");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(150, 204, 112));
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
        });
        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        bg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bgFocusLost(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(255, 255, 255));
        sidepane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidepaneMouseDragged(evt);
            }
        });
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_hospital.setBackground(new java.awt.Color(255, 255, 255));
        btn_hospital.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hospitalMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/002.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(150, 204, 112));
        jLabel2.setFont(new java.awt.Font("배달의민족 한나는 열한살", 0, 16)); // NOI18N
        jLabel2.setText("Shall we find the hospital?");

        javax.swing.GroupLayout btn_hospitalLayout = new javax.swing.GroupLayout(btn_hospital);
        btn_hospital.setLayout(btn_hospitalLayout);
        btn_hospitalLayout.setHorizontalGroup(
            btn_hospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hospitalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        btn_hospitalLayout.setVerticalGroup(
            btn_hospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hospitalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(btn_hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 360, 60));

        btn_drugstore.setBackground(new java.awt.Color(255, 255, 255));
        btn_drugstore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_drugstore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_drugstoreMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/045.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("배달의민족 한나는 열한살", 0, 16)); // NOI18N
        jLabel4.setText("Do you want to find a drugstore?");

        javax.swing.GroupLayout btn_drugstoreLayout = new javax.swing.GroupLayout(btn_drugstore);
        btn_drugstore.setLayout(btn_drugstoreLayout);
        btn_drugstoreLayout.setHorizontalGroup(
            btn_drugstoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_drugstoreLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        btn_drugstoreLayout.setVerticalGroup(
            btn_drugstoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_drugstoreLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepane.add(btn_drugstore, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 360, -1));

        btn_emergency.setBackground(new java.awt.Color(255, 255, 255));
        btn_emergency.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_emergencyMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/048.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("배달의민족 한나는 열한살", 0, 16)); // NOI18N
        jLabel6.setText("Should we find the emergency room?");

        javax.swing.GroupLayout btn_emergencyLayout = new javax.swing.GroupLayout(btn_emergency);
        btn_emergency.setLayout(btn_emergencyLayout);
        btn_emergencyLayout.setHorizontalGroup(
            btn_emergencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_emergencyLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        btn_emergencyLayout.setVerticalGroup(
            btn_emergencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_emergencyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepane.add(btn_emergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 360, -1));

        btn_emergencyroom.setBackground(new java.awt.Color(255, 255, 255));
        btn_emergencyroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_emergencyroomMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/062.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("배달의민족 한나는 열한살", 0, 16)); // NOI18N
        jLabel8.setText("Can I get an emergency room?");

        javax.swing.GroupLayout btn_emergencyroomLayout = new javax.swing.GroupLayout(btn_emergencyroom);
        btn_emergencyroom.setLayout(btn_emergencyroomLayout);
        btn_emergencyroomLayout.setHorizontalGroup(
            btn_emergencyroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_emergencyroomLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        btn_emergencyroomLayout.setVerticalGroup(
            btn_emergencyroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(btn_emergencyroomLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepane.add(btn_emergencyroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 360, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/KakaoTalk_20171215_162917492.gif"))); // NOI18N
        sidepane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 390, 430));

        jLabel20.setBackground(new java.awt.Color(150, 204, 112));
        jLabel20.setFont(new java.awt.Font("배달의민족 한나는 열한살", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(150, 204, 112));
        jLabel20.setText("동의대보감 ");
        sidepane.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 740));

        jLabel11.setFont(new java.awt.Font("휴먼아미체", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/X.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        ViewPanel.setBackground(new java.awt.Color(150, 204, 112));
        ViewPanel.setForeground(new java.awt.Color(0, 204, 0));

        jText_Search.setToolTipText("");
        jText_Search.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jText_Search.setDoubleBuffered(true);
        jText_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_SearchActionPerformed(evt);
            }
        });

        jButton_Search.setBackground(new java.awt.Color(150, 204, 112));
        jButton_Search.setForeground(new java.awt.Color(150, 204, 112));
        jButton_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/검색.png"))); // NOI18N
        jButton_Search.setBorderPainted(false);
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable_Users.setAutoCreateRowSorter(true);
        jTable_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idx", "level", "addr", "name", "tel1", "Title 6", "Title 7"
            }
        ));
        jTable_Users.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Users.setDragEnabled(true);
        jTable_Users.setEnabled(false);
        jTable_Users.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_Users.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable_Users.setRowHeight(25);
        jTable_Users.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane1.setViewportView(jTable_Users);

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jText_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jText_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Search))
                .addContainerGap(460, Short.MAX_VALUE))
            .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewPanelLayout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        bg.add(ViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 860, 520));

        jLabel13.setFont(new java.awt.Font("배달의민족 한나는 열한살", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 650, 400, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/감기.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        bg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 640, 50, -1));

        jLabel9.setFont(new java.awt.Font("궁서", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(187, 204, 175));
        jLabel9.setText("東義大 寶鑑");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 224, 28));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/감기걸린아이.png"))); // NOI18N
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, -1, -1));

        jLabel19.setBackground(new java.awt.Color(150, 204, 112));
        jLabel19.setFont(new java.awt.Font("배달의민족 한나는 열한살", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(150, 204, 112));
        jLabel19.setText("동의 대 보감 ");
        bg.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanel1.setBackground(new java.awt.Color(150, 204, 112));
        jPanel1.setForeground(new java.awt.Color(150, 204, 112));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 920, 10));

        jPanel2.setBackground(new java.awt.Color(150, 204, 112));
        jPanel2.setForeground(new java.awt.Color(150, 204, 112));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        jPanel3.setBackground(new java.awt.Color(150, 204, 112));
        jPanel3.setForeground(new java.awt.Color(150, 204, 112));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 30, 510));

        jPanel4.setBackground(new java.awt.Color(150, 204, 112));
        jPanel4.setForeground(new java.awt.Color(150, 204, 112));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 120, -1, 510));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project19/images/동의대보감3.gif"))); // NOI18N
        bg.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bgFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bgFocusLost

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_bgMouseDragged

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        // TODO add your handling code here:
        if (information == 1) {
            HospitalfindUsers();//병원검색기능        
        }
        if (information == 2) {
            PharmacyfindUsers();//약국검색기능
        }
        if (information == 3) {
            EmergencyfindUsers();//응급실검색기능
        }
        if (information == 4) {
           EmergencroomyfindUsers();//응급실검색기능
        }
    
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jText_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_SearchActionPerformed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MousePressed

    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_sidepaneMouseDragged

    private void btn_emergencyroomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_emergencyroomMousePressed
        // TODO add your handling code here:
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(150,204,112));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));

        ViewPanel.setVisible(true);
        btn_emergencyroom.setOpaque(true);
        btn_emergency.setOpaque(false);
        btn_hospital.setOpaque(false);
        btn_drugstore.setOpaque(false);
        EmergencyroomData();
        information = 4;
    }//GEN-LAST:event_btn_emergencyroomMousePressed

    private void btn_emergencyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_emergencyMousePressed
        // TODO add your handling code here:
        jLabel2.setForeground(new java.awt.Color(0,0, 0));
        jLabel4.setForeground(new java.awt.Color(0,0, 0));
        jLabel6.setForeground(new java.awt.Color(150,204,112));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        ViewPanel.setVisible(true);
        btn_emergency.setOpaque(true);
        btn_drugstore.setOpaque(false);
        btn_hospital.setOpaque(false);
        btn_emergencyroom.setOpaque(false);
        information = 3;
        EmergencyData();
    }//GEN-LAST:event_btn_emergencyMousePressed

    private void btn_drugstoreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_drugstoreMousePressed
        // TODO add your handling code here:
        jLabel2.setForeground(new java.awt.Color(0,0, 0));
        jLabel4.setForeground(new java.awt.Color(150,204,112));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        ViewPanel.setVisible(true);
        btn_drugstore.setOpaque(true);

        btn_emergency.setOpaque(false);
        btn_hospital.setOpaque(false);
        btn_emergencyroom.setOpaque(false);
         information = 2;
        PharmacyData();

    }//GEN-LAST:event_btn_drugstoreMousePressed

    private void btn_hospitalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hospitalMousePressed
        // TODO add your handling code here:
        jLabel2.setForeground(new java.awt.Color(150,204,112));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        ViewPanel.setVisible(true);
        btn_hospital.setOpaque(true);
        btn_drugstore.setOpaque(false);
        btn_emergency.setOpaque(false);
        btn_emergencyroom.setOpaque(false);
        information = 1;
        HospitalData();//데이터를 불러와준다.
    }//GEN-LAST:event_btn_hospitalMousePressed
    /**/
    void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 65, 118));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
    }

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        new Home19().setVisible(true);

    

    }
    int xx;
    int xy;
    int information = 0;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewPanel;
    public javax.swing.JPanel bg;
    private javax.swing.JPanel btn_drugstore;
    private javax.swing.JPanel btn_emergency;
    private javax.swing.JPanel btn_emergencyroom;
    private javax.swing.JPanel btn_hospital;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_Users;
    private javax.swing.JTextField jText_Search;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
