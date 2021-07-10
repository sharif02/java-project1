/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import java.sql.ResultSet;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class Employee extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement post;
    ResultSet result;
    
    public Employee() {
        initComponents();
        con = Connect.conect();
        tableview();
    }

    public void insert() {
        try {
            String ins = "INSERT INTO `employe`(`Id`,`Name`,`Number`,`Email`,`Status`)"
                    + " VALUES ('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField5.getText()+"','"+jTextField4.getText()+"','"+jComboBox1.getSelectedItem()+"')";
            post = con.prepareStatement(ins);
            post.execute();
            JOptionPane.showMessageDialog(null, "Insert Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }
    }

    public void Update() {
        try {
            String updat = "UPDATE `employe` SET `Name`='', `Number`='',`Email`='',`Status`='' WHERE `Id`=''";
            post = con.prepareStatement(updat);
            post.execute();
            JOptionPane.showMessageDialog(null, "Update Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
    }

    public void Delete() {
        try {
            String Del = "DELETE FROM `employe` WHERE `Id`='' ";
            post = con.prepareStatement(Del);
            post.execute();
            JOptionPane.showMessageDialog(null, "Delete Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
    public void tableview(){
        try {
            String query="SELECT * FROM `employe`";
            post = con.prepareStatement(query);
            result =post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        kButton1 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();
        kButton6 = new keeptoo.KButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setTitle("Employee Information");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Number", "Email", "Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Employee Id");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Employee Name");

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField2.setText("Enter name");
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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Designation");

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField3.setText("Enter Designation");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField5.setText("Enter Number");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Mobile Number");

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jTextField5))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 255));
        kGradientPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField4.setText("Enter Email");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Address\n");
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee Stastus" }));

        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton1.setkBorderRadius(15);
        kButton1.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton1.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton1.setkIndicatorThickness(0);
        kButton1.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setText("Edit");
        kButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton2.setkBorderRadius(15);
        kButton2.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton2.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton2.setkIndicatorThickness(0);
        kButton2.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton2.setOpaque(false);
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("View");
        kButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton3.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton3.setkBorderRadius(15);
        kButton3.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton3.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton3.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton3.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton3.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton3.setkIndicatorThickness(0);
        kButton3.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton3.setOpaque(false);
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton4.setText("Delete");
        kButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton4.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton4.setkBorderRadius(15);
        kButton4.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton4.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton4.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton4.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton4.setkIndicatorThickness(0);
        kButton4.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton4.setOpaque(false);
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setText("Exit");
        kButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton5.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton5.setkBorderRadius(15);
        kButton5.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton5.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton5.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton5.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton5.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton5.setkIndicatorThickness(0);
        kButton5.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton5.setOpaque(false);
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        kButton6.setText("Clean");
        kButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton6.setkBackGroundColor(new java.awt.Color(204, 204, 255));
        kButton6.setkBorderRadius(15);
        kButton6.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton6.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        kButton6.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton6.setkHoverStartColor(new java.awt.Color(204, 204, 255));
        kButton6.setkIndicatorColor(new java.awt.Color(153, 153, 255));
        kButton6.setkIndicatorThickness(0);
        kButton6.setkStartColor(new java.awt.Color(204, 153, 255));
        kButton6.setOpaque(false);
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
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

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (jTextField2.getText().equals("Enter name")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if (jTextField2.getText().equals("Enter name")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (jTextField2.getText().equals("")) {
            jTextField2.setText("Enter name");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (jTextField3.getText().equals("Enter Designation")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (jTextField3.getText().equals("Enter Designation")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if (jTextField3.getText().equals("")) {
            jTextField3.setText("Enter Designation");
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jDateChooser1.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        if (jTextField5.getText().equals("Enter Number")) {
            jTextField5.setText(null);
        }
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
       if (jTextField5.getText().equals("Enter Number")) {
            jTextField5.setText(null);
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
       if (jTextField5.getText().equals("")) {
            jTextField5.setText("Enter Number");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (jTextField4.getText().equals("Enter Email")) {
            jTextField4.setText(null);
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
         if (jTextField4.getText().equals("Enter Email")) {
            jTextField4.setText(null);
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if (jTextField4.getText().equals("")) {
            jTextField4.setText("Enter Email");
        }
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox1.requestFocus();
        } 
    }//GEN-LAST:event_jTextField4KeyReleased

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        insert();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        Update();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        tableview();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        jTextField1.setText("Enter Id");
        jTextField2.setText("Enter name");
        jTextField3.setText("Enter Designation");
        jTextField4.setText("Enter Email");
        jTextField5.setText("Enter Number");
        jTextArea1.setText("Address" );
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
       Delete();
    }//GEN-LAST:event_kButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
