    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class Brands extends javax.swing.JInternalFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement post;

    public Brands() {
        initComponents();
        con = Connect.conect();
        tableView();
    }

    public void insert() {
        try {
            String ins = "INSERT INTO `brand`(`Brand_id`,`Brand_Name`) VALUES('" + enter_id.getText() + "','" + brand_name.getText() + "')";
            post = con.prepareStatement(ins);
            post.execute();
            JOptionPane.showMessageDialog(null, "Insert Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }
        tableView();
    }

    public void Update() {
        try {
            String updat = "UPDATE `brand` SET `Brand_Name`='" + brand_name.getText() + "' WHERE `Brand_id`='" + enter_id.getText() + "'";
            post = con.prepareStatement(updat);
            post.execute();
            JOptionPane.showMessageDialog(null, "Update Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
        tableView();
    }

    public void Delete() {
        try {
            String Del = "DELETE FROM `brand` WHERE `Brand_id`='" + enter_id.getText() + "'";
            post = con.prepareStatement(Del);
            post.execute();
            JOptionPane.showMessageDialog(null, "Delete Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
        tableView();
    }

    private void tableView() {
        try {
            String sql = "SELECT * FROM brand";
            post = con.prepareStatement(sql);
            rs = post.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }

    private void tableSelectedRow() {
        try {

            int row = jTable2.getSelectedRow();
            String id = (jTable2.getModel().getValueAt(row, 0).toString());
            String sql = "SELECT * FROM brand WHERE Brand_id='" + id + "'";
            post = con.prepareStatement(sql);
            rs = post.executeQuery();
            if (rs.next()) {
                enter_id.setText(rs.getString("Brand_id"));
                brand_name.setText(rs.getString("Brand_Name"));
            }
        } catch (Exception e) {
        }
    }
    public void search1(){
        try {
            String search = "SELECT * FROM `brand` WHERE Brand_Name LIKE '%"+jTextField6.getText()+"%' " ;
            post = con.prepareStatement(search);
            rs = post.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }
    public void seacrh2(){
        try {
          String search = "SELECT * FROM `brand` WHERE Brand_id LIKE '%"+jTextField6.getText()+"%' " ;
            post = con.prepareStatement(search);
            rs = post.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        kButton1 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();
        kButton6 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        enter_id = new javax.swing.JTextField();
        brand_name = new javax.swing.JTextField();
        kButton7 = new keeptoo.KButton();
        kButton8 = new keeptoo.KButton();
        kButton9 = new keeptoo.KButton();
        kButton10 = new keeptoo.KButton();
        kButton11 = new keeptoo.KButton();
        kButton12 = new keeptoo.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(231, 207, 255));
        setBorder(null);
        setClosable(true);
        setMaximizable(true);

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setTitle("Category Information");

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 0, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setText("Category Id");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("Category Name");

        jTextField1.setText("Enter Id");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setText("Enter Category Name");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        kButton1.setBorder(null);
        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton1.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton1.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton1.setOpaque(false);

        kButton2.setBorder(null);
        kButton2.setText("Edit");
        kButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton2.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton2.setOpaque(false);

        kButton3.setBorder(null);
        kButton3.setText("Delete");
        kButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton3.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton3.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton3.setOpaque(false);

        kButton4.setBorder(null);
        kButton4.setText("Clean");
        kButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton4.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton4.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton4.setOpaque(false);
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setBorder(null);
        kButton5.setText("View");
        kButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton5.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton5.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton5.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton5.setOpaque(false);

        kButton6.setBorder(null);
        kButton6.setText("Exit");
        kButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton6.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton6.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton6.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton6.setOpaque(false);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addGap(62, 62, 62))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category Id", "Category Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 0, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Filter By");

        jRadioButton1.setText("Id");
        jRadioButton1.setBorder(null);
        jRadioButton1.setOpaque(false);

        jRadioButton2.setText("Name");
        jRadioButton2.setBorder(null);
        jRadioButton2.setOpaque(false);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField3.setText("Search");
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(231, 207, 255));

        kGradientPanel3.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(231, 207, 255));
        kGradientPanel3.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("Brand Id");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Category Name");

        enter_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enter_id.setText("Enter Id");
        enter_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enter_idMouseClicked(evt);
            }
        });
        enter_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_idActionPerformed(evt);
            }
        });
        enter_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enter_idKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enter_idKeyReleased(evt);
            }
        });

        brand_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        brand_name.setText("Enter Brand Name");
        brand_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brand_nameMouseClicked(evt);
            }
        });
        brand_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                brand_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brand_nameKeyReleased(evt);
            }
        });

        kButton7.setBorder(null);
        kButton7.setText("Add");
        kButton7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton7.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton7.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton7.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton7.setOpaque(false);
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton8.setBorder(null);
        kButton8.setText("Edit");
        kButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton8.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton8.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton8.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton8.setOpaque(false);
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        kButton9.setBorder(null);
        kButton9.setText("Delete");
        kButton9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton9.setkAllowTab(false);
        kButton9.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton9.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton9.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton9.setOpaque(false);
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });

        kButton10.setBorder(null);
        kButton10.setText("Clean");
        kButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton10.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton10.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton10.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton10.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton10.setOpaque(false);
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        kButton11.setBorder(null);
        kButton11.setText("View");
        kButton11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton11.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton11.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton11.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton11.setOpaque(false);

        kButton12.setBorder(null);
        kButton12.setText("Exit");
        kButton12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton12.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton12.setkHoverColor(new java.awt.Color(204, 204, 255));
        kButton12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton12.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kButton12.setkStartColor(new java.awt.Color(255, 153, 153));
        kButton12.setOpaque(false);
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enter_id)
                    .addComponent(brand_name, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addGap(62, 62, 62))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enter_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(brand_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Brand Id", "Brand Name"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        kGradientPanel4.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(204, 153, 255));
        kGradientPanel4.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Filter By");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Id");
        jRadioButton3.setBorder(null);
        jRadioButton3.setOpaque(false);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Name");
        jRadioButton4.setBorder(null);
        jRadioButton4.setOpaque(false);

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField6.setText("Search");
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel4Layout.createSequentialGroup()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton4))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if (jTextField1.getText().equals("Enter Id")) {
            jTextField1.setText(null);
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (jTextField1.getText().equals("Enter Id")) {
            jTextField1.setText(null);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (jTextField1.getText().equals("")) {
            jTextField1.setText("Enter Id");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if (jTextField2.getText().equals("Enter Brand Name")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (jTextField2.getText().equals("Enter Brand Name")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (jTextField2.getText().equals("")) {
            jTextField2.setText("Enter Brand Name");
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        jTextField1.setText("Enter Id");
        jTextField2.setText("Enter Brand Name");
    }//GEN-LAST:event_kButton4ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (jTextField2.getText().equals("Search")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        if (jTextField2.getText().equals("Search")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        tableSelectedRow();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
       if(jRadioButton3.isSelected()){
       seacrh2();
       }
       else if(jRadioButton4.isSelected()){
       search1();
       }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_kButton12ActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        enter_id.setText("Enter Id");
        brand_name.setText("Enter Brand Name");
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        Delete();
    }//GEN-LAST:event_kButton9ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        Update();
    }//GEN-LAST:event_kButton8ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        insert();
    }//GEN-LAST:event_kButton7ActionPerformed

    private void brand_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brand_nameKeyReleased
        if (brand_name.getText().equals("")) {
            brand_name.setText("Enter Brand Name");
        }
    }//GEN-LAST:event_brand_nameKeyReleased

    private void brand_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brand_nameKeyPressed
        if (brand_name.getText().equals("Enter Brand Name")) {
            brand_name.setText(null);
        }
    }//GEN-LAST:event_brand_nameKeyPressed

    private void brand_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brand_nameMouseClicked
        if (brand_name.getText().equals("Enter Brand Name")) {
            brand_name.setText(null);
        }
    }//GEN-LAST:event_brand_nameMouseClicked

    private void enter_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enter_idKeyReleased
        if (enter_id.getText().equals("")) {
            enter_id.setText("Enter Id");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            brand_name.requestFocus();
        }
    }//GEN-LAST:event_enter_idKeyReleased

    private void enter_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enter_idKeyPressed
        if (enter_id.getText().equals("Enter Id")) {
            enter_id.setText(null);
        }
    }//GEN-LAST:event_enter_idKeyPressed

    private void enter_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_idActionPerformed

    }//GEN-LAST:event_enter_idActionPerformed

    private void enter_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enter_idMouseClicked
        if (jTextField1.getText().equals("Enter Id")) {
            jTextField1.setText(null);
        }
    }//GEN-LAST:event_enter_idMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brand_name;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField enter_id;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton12;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    // End of variables declaration//GEN-END:variables

}
