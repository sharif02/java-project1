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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class Daily_Costing extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement post;
    ResultSet result;
    String id;

    public Daily_Costing() {
        initComponents();
        con = Connect.conect();
        
        Selectrow();
        if(jRadioButton1.isSelected())
            TableView();
        else if (jRadioButton2.isSelected())
            System.out.println("Hello");

    }

    public void income() {
        try {
            Date date = jDateChooser1.getDate();
            SimpleDateFormat formate = new SimpleDateFormat("yy-MM-dd");
            String thisdate = formate.format(date);

            String query = "INSERT INTO `dialy_income`(`income_source`,`amount`,`date`)"
                    + " VALUES('" + jComboBox1.getSelectedItem() + "', '" + jTextField3.getText() + "' , '" + thisdate + "')";
            post = con.prepareStatement(query);
            post.execute();
            JOptionPane.showMessageDialog(null, "Sucess");
        } catch (Exception e) {
        }
    }

    public void expense() {
        try {
            Date date = jDateChooser1.getDate();
            SimpleDateFormat dateformate = new SimpleDateFormat("yy-MM-dd");
            String thisdate = dateformate.format(date);

            String ins = "INSERT INTO `daily_cost`(`Expense_Source`,`Amount`,`Date`) "
                    + "VALUES('" + jComboBox1.getSelectedItem() + "','" + jTextField3.getText() + "','" + thisdate + "')";
            post = con.prepareStatement(ins);
            post.execute();
            JOptionPane.showMessageDialog(null, "Insert Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }
    }

    public void Update() {
        try {
            Date date = jDateChooser1.getDate();
            SimpleDateFormat dateformate = new SimpleDateFormat("yy-MM-dd");
            String thisdate = dateformate.format(date);

            String updat = "UPDATE `daily_cost` SET `Expense_Source`='" + jComboBox1.getSelectedItem() + "',`Amount`='" + jTextField3.getText() + "' WHERE `Invoice_id`";
            post = con.prepareStatement(updat);
            post.execute();
            JOptionPane.showMessageDialog(null, "Update Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
    }

    public void Delete() {
        try {

            String Del = "DELETE FROM `daily_cost` WHERE `invoice_id`= '"+id+"'";
            post = con.prepareStatement(Del);
            post.execute();
            JOptionPane.showMessageDialog(null, "Delete Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }

    public void TableView() {
        try {
            String View = "SELECT * FROM dialy_income ";
            post = con.prepareStatement(View);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
        }

    }
    public void tableviwe(){
        try {
            String View = "SELECT * FROM daily_cost ";
            post = con.prepareStatement(View);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
            
        } catch (Exception e) {
        }
    }

    public void Selectrow() {
        try {
            int getrow = jTable1.getSelectedRow();
             id = (jTable1.getModel().getValueAt(getrow, 0).toString());
            String query = "SELECT * FROM `daily_cost` WHERE Invoice_id='" + id + "'";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            if (result.next()) {

                jComboBox1.setSelectedItem(result.getString("Expense_Source"));

                jTextField3.setText(result.getString("Amount"));
            }
        } catch (Exception e) {
        }

    }

    public void getexpense() {
        try {
            String getname = jComboBox2.getSelectedItem().toString();
            String query = "SELECT `title` FROM `income_expense` WHERE income_expense = '" + getname + "'";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            jComboBox1.removeAllItems();
            while (result.next()) {
                jComboBox1.addItem(result.getString("title"));
            }
        } catch (Exception e) {
        }

    }

    public void search() {
        try {
            String View = "SELECT * FROM daily_cost where Expense_Source like '%"+jTextField4.getText()+"%'";
            post = con.prepareStatement(View);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
        }
    }
    public void Searche(){
        try {
            String views ="SELECT * FROM dialy_income where income_source like '%"+jTextField4.getText()+"%'";
            post = con.prepareStatement(views);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
            
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        kButton1 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();
        kButton6 = new keeptoo.KButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setTitle("Daily Cost Information");

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 153, 255));

        jLabel2.setText("Date");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("expense source");

        jTextField3.setText("Enter Amount");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField3MouseExited(evt);
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

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });

        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Amount");

        kButton1.setBorder(null);
        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton1.setkBorderRadius(30);
        kButton1.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton1.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setBorder(null);
        kButton2.setText("Edit");
        kButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton2.setkBorderRadius(30);
        kButton2.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton2.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton2.setOpaque(false);
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setBorder(null);
        kButton3.setText("Delete");
        kButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton3.setkBorderRadius(30);
        kButton3.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton3.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton3.setOpaque(false);
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton4.setBorder(null);
        kButton4.setText("Clean");
        kButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton4.setkBorderRadius(30);
        kButton4.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton4.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton4.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton4.setOpaque(false);
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setBorder(null);
        kButton5.setText("View");
        kButton5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton5.setkBorderRadius(30);
        kButton5.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton5.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton5.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton5.setOpaque(false);
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        kButton6.setBorder(null);
        kButton6.setText("Exit");
        kButton6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        kButton6.setkBorderRadius(30);
        kButton6.setkEndColor(new java.awt.Color(204, 153, 255));
        kButton6.setkHoverEndColor(new java.awt.Color(255, 204, 153));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        kButton6.setkStartColor(new java.awt.Color(0, 102, 102));
        kButton6.setOpaque(false);
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Income", "Expense" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 153, 255));

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField4.setText("Search");
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("income");
        jRadioButton1.setBorder(null);
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton2.setText("expense");
        jRadioButton2.setBorder(null);
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Filter By");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)))
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Invoice Id", "Expense Source", "Voucer No", "Amount", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (jTextField3.getText().equals("Enter Amount")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseExited
        if (jTextField3.getText().equals("")) {
            jTextField3.setText("Enter Amount");
        }
    }//GEN-LAST:event_jTextField3MouseExited

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (jTextField3.getText().equals("Enter Amount")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if (jTextField3.getText().equals("")) {
            jTextField3.setText("Enter Amount");
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox1.requestFocus();
        }
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased

    }//GEN-LAST:event_jComboBox1KeyReleased

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed

        jDateChooser1.setToolTipText(null);

        jTextField3.setText("Enter Amount");
    }//GEN-LAST:event_kButton4ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        if (jTextField4.getText().equals("Search")) {
            jTextField4.setText(null);
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        TableView();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        if (jComboBox2.getSelectedItem().equals("Income")) {
            income();
        } else if (jComboBox2.getSelectedItem().equals("Expense")) {
            expense();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        Update();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        Delete();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_kButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Selectrow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        getexpense();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if(jRadioButton1.isSelected()){
        
        Searche();
        }
        else if(jRadioButton2.isSelected()){
        
        search();}
       
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected())
            TableView();
       
            
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected())
            tableviwe();
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
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
