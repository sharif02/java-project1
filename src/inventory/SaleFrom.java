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
public class SaleFrom extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement post;
    ResultSet result;

    public SaleFrom() {
        initComponents();
        con = Connect.conect();
        tableView();
        getcustomer();
        getcategory();
        getProduct();
        getBrand();
        getMasuerment();

    }

    public void insert() {
        try {
            String query = "INSERT INTO `sales`(`Invoice_id`,`Name`,`Product`,`Quantity`,`Number`,`Sale_price`,`Paid`,`Due`) "
                    + "VALUES('" + jTextField1.getText() + "','" + CustomerCombo.getSelectedItem() + "','" + jComboBox3.getSelectedItem() + "','" + jTextField4.getText() + "',"
                    + " '" + jTextField2.getText() + "','" + jTextField7.getText() + "','" + jTextField14.getText() + "','" + jTextField15.getText() + "')";
            post = con.prepareStatement(query);
            post.execute();
            JOptionPane.showMessageDialog(null, "Insert SucessFully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Insert Failed", JOptionPane.WARNING_MESSAGE);

        }

    }

    public void update() {
        try {
            String updat = "UPDATE `sales` SET `Name`='" + CustomerCombo.getSelectedItem() + "',`Product`='" + jComboBox3.getSelectedItem() + "',`Quantity`='" + jTextField4.getText() + "',"
                    + "`Number`='" + jTextField2.getText() + "',`Sale_price`='" + jTextField7.getText() + "',`Paid`='" + jTextField14.getText() + "',`Due`='" + jTextField15.getText() + "' WHERE `Invoice_id`='" + jTextField1.getText() + "'";
            post = con.prepareStatement(updat);
            post.execute();
            JOptionPane.showMessageDialog(null, "Update Sucessfull");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
    }

    public void delete() {
        try {
            String delet = "DELETE FROM `sales` WHERE `Invoice_id`='" + jTextField1.getText() + "'";
            post = con.prepareStatement(delet);
            post.execute();
            JOptionPane.showMessageDialog(null, "Delete Sucessfull");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }

    public void tableView() {
        try {
            String sql = "SELECT * FROM `sales` ";
            post = con.prepareStatement(sql);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void SelectTable() {
        try {
            int getrow = jTable1.getSelectedRow();
            String getcolum = (jTable1.getModel().getValueAt(getrow, 0).toString());
            String query = "SELECT * FROM `sales` ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            if (result.next()) {
                jTextField1.setText(result.getString("Invoice_id"));
                CustomerCombo.setSelectedItem(result.getString("Name"));
                jComboBox3.setSelectedItem(result.getString("Product"));
                jTextField4.setText(result.getString("Quantity"));
                jTextField2.setText(result.getString("Number"));
                jTextField7.setText(result.getString("Sale_price"));
                jTextField14.setText(result.getString("Paid"));
                jTextField15.setText(result.getString("Due"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Failed ", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void getcustomer() {
        try {
            String get = "SELECT * FROM `customer` ";
            post = con.prepareStatement(get);
            result = post.executeQuery();
            while (result.next()) {
                CustomerCombo.addItem(result.getString("Name"));
            }
        } catch (Exception e) {
        }

    }

    public void getcategory() {
        try {
            String get = "SELECT * FROM `category`";
            post = con.prepareStatement(get);
            result = post.executeQuery();
            while (result.next()) {
                jComboBox2.addItem(result.getString("Category_name"));
            }
        } catch (Exception e) {
        }

    }

    public void getProduct() {
        try {
            String get = "SELECT * FROM `product`";
            post = con.prepareStatement(get);
            result = post.executeQuery();
            while (result.next()) {
                jComboBox3.addItem(result.getString("product_name"));

            }
        } catch (Exception e) {
        }

    }

    public void getCustomer() {
        try {
            String query = "SELECT * FROM `customer` ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            while (result.next()) {
                CustomerCombo.addItem(result.getString("Name"));
            }
        } catch (Exception e) {
        }
    }
    public void getBrand(){
    try {
            String query ="SELECT * FROM `brand`";
            post =con.prepareStatement(query);
            result =post.executeQuery();
            while(result.next()){
            jComboBox4.addItem(result.getString("Brand_Name"));
            }
        } catch (Exception e) {
        }
    }
    public void getMasuerment(){
        try {
            String query ="SELECT * FROM `masuerment`";
            post = con.prepareStatement(query);
            result =post.executeQuery();
            while(result.next()){
            jComboBox5.addItem(result.getString("Masuerment_type"));
            }
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        CustomerCombo = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        kButton1 = new keeptoo.KButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        kButton6 = new keeptoo.KButton();
        kButton7 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setTitle("Sale Information");

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel1.setText("Invoice Id");

        jLabel2.setText("Invoice Date");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel4.setText("Customer Phone");

        jTextField1.setText("Enter Invoice Id");
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

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });

        CustomerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer" }));
        CustomerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerComboActionPerformed(evt);
            }
        });
        CustomerCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CustomerComboKeyReleased(evt);
            }
        });

        jTextField2.setText("Enter Number");
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

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("Category");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Product");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Product" }));
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox3KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Purches Price");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("Discount");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel9.setText("Quantity");

        jTextField3.setText("Enter Purches price");
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

        jTextField4.setText("1");
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

        jTextField5.setText("Enter Discount");
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

        jTextField6.setText("Enter bar code");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTextField7.setText("Enter sale price");
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jTextField8.setText("Enter Total sale price");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel10.setText("Sale price");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Total Sale price");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel12.setText("Brand");

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel13.setText("Unit");

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel14.setText("Bar code");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Brand" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox4KeyReleased(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Unit" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox5KeyReleased(evt);
            }
        });

        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(255, 204, 153));
        kButton1.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkStartColor(new java.awt.Color(255, 204, 204));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CustomerCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField7)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(CustomerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13)))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jComboBox5))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel15.setText("Total amount");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel16.setText("Vhat");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel17.setText("Total");

        jTextField9.setText("Enter total amount");
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jTextField10.setText("Enter Vhat");
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jTextField11.setText("Enter total amount");
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11MouseClicked(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel20.setText("Paid");

        jTextField14.setText("Paid Amount");
        jTextField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField14MouseClicked(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel21.setText("Due");

        jTextField15.setText("Due Amount");
        jTextField15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField15MouseClicked(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });

        jCheckBox1.setText("Submit With Invoice");
        jCheckBox1.setBorder(null);
        jCheckBox1.setOpaque(false);

        kButton6.setText("View");
        kButton6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        kButton6.setkEndColor(new java.awt.Color(255, 204, 153));
        kButton6.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkStartColor(new java.awt.Color(255, 204, 204));
        kButton6.setOpaque(false);
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        kButton7.setText("Submit");
        kButton7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        kButton7.setkEndColor(new java.awt.Color(255, 204, 153));
        kButton7.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkStartColor(new java.awt.Color(255, 204, 204));
        kButton7.setOpaque(false);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox1)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice Id", "C/Name", "Product", "Sale Price", "Quantity", "Date", "Paid", "Due"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if (jTextField1.getText().equals("Enter Invoice Id")) {
            jTextField1.setText(null);
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (jTextField1.getText().equals("Enter Invoice Id")) {
            jTextField1.setText(null);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (jTextField1.getText().equals("")) {
            jTextField1.setText("Enter Invoice Id");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CustomerCombo.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void CustomerComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerComboKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_CustomerComboKeyReleased

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if (jTextField2.getText().equals("Enter Number")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (jTextField2.getText().equals("Enter Number")) {
            jTextField2.setText(null);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (jTextField2.getText().equals("")) {
            jTextField2.setText("Enter Number");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox4.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jComboBox3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyReleased

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (jTextField3.getText().equals("Enter Purches price")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (jTextField3.getText().equals("Enter Purches price")) {
            jTextField3.setText(null);
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if (jTextField3.getText().equals("")) {
            jTextField3.setText("Enter Purches price");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        if (jTextField4.getText().equals("Enter Quantity")) {
            jTextField4.setText(null);
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (jTextField4.getText().equals("Enter Quantity")) {
            jTextField4.setText(null);
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if (jTextField4.getText().equals("")) {
            jTextField4.setText("Enter Quantity");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField5.requestFocus();
        }
        try {
            Double quantity = Double.parseDouble(jTextField4.getText());
        Double purches = Double.parseDouble(jTextField3.getText());
        Double result = quantity*purches;
        jTextField7.setText(String.valueOf(result));
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        if (jTextField5.getText().equals("Enter Discount")) {
            jTextField5.setText(null);
        }
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        if (jTextField5.getText().equals("Enter Discount")) {
            jTextField5.setText(null);
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        if (jTextField5.getText().equals("")) {
            jTextField5.setText("Enter Discount");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jDateChooser1.requestFocus();
        }
        try {
            Double Discount = Double.parseDouble(jTextField5.getText());
            Double saleprice = Double.parseDouble(jTextField7.getText());
            Double result = saleprice - Discount ;
            jTextField8.setText(String.valueOf(result));
             
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        if (jTextField6.getText().equals("Enter bar code")) {
            jTextField6.setText(null);
        }
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        if (jTextField6.getText().equals("Enter bar code")) {
            jTextField6.setText(null);
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        if (jTextField6.getText().equals("")) {
            jTextField6.setText("Enter bar code");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField7.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        if (jTextField7.getText().equals("Enter sale price")) {
            jTextField7.setText(null);
        }
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        if (jTextField7.getText().equals("Enter sale price")) {
            jTextField7.setText(null);
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        if (jTextField7.getText().equals("")) {
            jTextField7.setText("Enter sale price");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox5.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        if (jTextField8.getText().equals("Enter Total sale price")) {
            jTextField8.setText(null);
        }
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        if (jTextField8.getText().equals("Enter Total sale price")) {
            jTextField8.setText(null);
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        if (jTextField8.getText().equals("")) {
            jTextField8.setText("Enter Total sale price");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField9.requestFocus();
        }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jComboBox4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jComboBox4KeyReleased

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        getMasuerment();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField8.requestFocus();
        }
    }//GEN-LAST:event_jComboBox5KeyReleased

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        if (jTextField9.getText().equals("Enter total amount")) {
            jTextField9.setText(null);
        }
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        if (jTextField9.getText().equals("Enter total amount")) {
            jTextField9.setText(null);
        }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        if (jTextField9.getText().equals("")) {
            jTextField9.setText("Enter total amount");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField10.requestFocus();
        }
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        if (jTextField10.getText().equals("Enter Vhat")) {
            jTextField10.setText(null);
        }
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        if (jTextField10.getText().equals("Enter Vhat")) {
            jTextField10.setText(null);
        }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        if (jTextField10.getText().equals("")) {
            jTextField10.setText("Enter Vhat");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField11.requestFocus();
        }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseClicked
        if (jTextField11.getText().equals("Enter total amount")) {
            jTextField11.setText(null);
        }
    }//GEN-LAST:event_jTextField11MouseClicked

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        if (jTextField11.getText().equals("Enter total amount")) {
            jTextField11.setText(null);
        }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        if (jTextField11.getText().equals("")) {
            jTextField11.setText("Enter total amount");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField14.requestFocus();
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseClicked
        if (jTextField14.getText().equals("Paid Amount")) {
            jTextField14.setText(null);
        }
    }//GEN-LAST:event_jTextField14MouseClicked

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
        if (jTextField14.getText().equals("Paid Amount")) {
            jTextField14.setText(null);
        }
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        if (jTextField14.getText().equals("")) {
            jTextField14.setText("Paid Amount");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField15.requestFocus();
        }
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jTextField15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField15MouseClicked
        if (jTextField15.getText().equals("Due Amount")) {
            jTextField15.setText(null);
        }
    }//GEN-LAST:event_jTextField15MouseClicked

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed
        if (jTextField15.getText().equals("Due Amount")) {
            jTextField15.setText(null);
        }
    }//GEN-LAST:event_jTextField15KeyPressed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        if (jTextField15.getText().equals("")) {
            jTextField15.setText("Due Amount");
        }
    }//GEN-LAST:event_jTextField15KeyReleased

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        insert();
        tableView();
        
        try {
            String querys = "SELECT SUM(Total_Price) AS 'total' FROM `curent_sales`";
            post = con.prepareStatement(querys);
            result = post.executeQuery();
            if (result.next()) 
            {
                jTextField9.setText(result.getString("total"));
            };
        } catch (Exception e) {
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        tableView();

    }//GEN-LAST:event_kButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        SelectTable();
    }//GEN-LAST:event_jTable1MouseClicked

    private void CustomerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerComboActionPerformed
        getCustomer();
        try {
            String getname =CustomerCombo.getSelectedItem().toString();
            String query ="SELECT `Number` FROM `customer` WHERE Name= '"+getname+"' ";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CustomerComboActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        getBrand();
    }//GEN-LAST:event_jComboBox4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CustomerCombo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
