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
import java.util.logging.Level;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class Purches extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement post;
    ResultSet result,resuilt2 ;
    double var;
    String proid;
    int invoice;

    public Purches() {
        initComponents();
        con = Connect.conect();
        TableView();
        selectSuppliar();
        GetProduct();
        getmasurement();
        autoid();
        clearShoppingcard();
        

    }
    public void getresult(){
        try {
            Date date = jDateChooser3.getDate();
            SimpleDateFormat dforamte = new SimpleDateFormat("yyyy-MM-dd");
            String thisDate = dforamte.format(date);
            String query = "SELECT SUM(net_total_amount)AS 'total' FROM `purches_leger` WHERE invoic_date BETWEEN 'CURDATE' AND '"+thisDate+"'";
            post = con.prepareStatement(query);
            result = post.executeQuery();

        } catch (Exception e) {
        }
    
    }

    public void autoid() {
        try {
            String query = "SELECT MAX(`invoice_no`) AS 'invoice' FROM `purches_leger`";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            if (result.next()) {
                invoice = Integer.parseInt(result.getString("invoice"));
                invoice++;
                jTextField1.setText(String.valueOf(invoice));

            }

        } catch (Exception e) {
            invoice = 1;
            jTextField1.setText(String.valueOf(invoice));

        }
     }

    public void Insert() {
        try {

            String query = "INSERT INTO `curent_purches_table`(`Invoice`,`Product_Id`,`Product_name`,`Quantity`,`Purches_Price`,`Discount`,`Total_Price`,`Sale_Price_Per`,Session) "
                    + "VALUES('" + jTextField1.getText() + "','" + proid + "','"+jTextField15.getText()+"','" + jTextField5.getText() + "',"
                    + "'" + jTextField6.getText() + "','" + jTextField8.getText() + "','" + jTextField7.getText() + "',"
                    + "'" + jTextField9.getText() + "','" + jTextField1.getText() + "')";
            post = con.prepareStatement(query);
            post.execute();
            String querys = "SELECT SUM(Total_Price) AS 'total' FROM `curent_purches_table`";
            post = con.prepareStatement(querys);
            result = post.executeQuery();
            if (result.next()) {
                jTextField10.setText(result.getString("total"));
            }
            

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e, "Insert Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void TableView() {
        try {
            String Query = "SELECT * FROM `curent_purches_table`";
            post = con.prepareStatement(Query);
            result = post.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(result));

        } catch (Exception e) 
        {
            }
    }

    public void clearShoppingcard() {
        try {
            String query ="DELETE FROM curent_purches_table";
            post = con.prepareStatement(query);
            post.execute();
            
        } catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, "Failed");
        }
        }

    public void SelectRow() {
        try {
            int getrow = jTable1.getSelectedRow();
            String getColum = (jTable1.getModel().getValueAt(getrow, 0).toString());
            String Query = "SELECT * FROM `curent_purches_table` WHERE  `Id`='" + getColum + "' ";
            post = con.prepareStatement(Query);
            result = post.executeQuery();
            if (result.next()) {

                jTextField3.setText(result.getString("Voucer_No"));
                jComboBox2.setSelectedItem(result.getString("Select_Product"));
                jTextField5.setText(result.getString("Quantity"));
                jTextField6.setText(result.getString("Purches_Price"));
                jComboBox1.setSelectedItem(result.getString("Select_Suppliar"));
            }

        } catch (Exception e) 
            {
            }
    }

    public void selectSuppliar() {
        try {
            String query = "SELECT * FROM `suppliar` ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            while (result.next()) {
                jComboBox1.addItem(result.getString("Name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Failed", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void getmasurement() {
        try {
            String query = "SELECT * FROM `masuerment` ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            while (result.next()) {
                jComboBox3.addItem(result.getString("Masuerment_type"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Failed", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void GetProduct() {
        try {
            String query = "SELECT * FROM `product`";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            while (result.next()) {
                jComboBox2.addItem(result.getString("product_name"));

            }
        } catch (Exception e) {
        }

    }
    public void leger(){
    try {
            Date date = jDateChooser1.getDate();
            SimpleDateFormat dateformate =new SimpleDateFormat("yyyy-MM-dd");
            String thisDate = dateformate.format(date);
            
            String query ="INSERT INTO `purches_leger`(`invoice_no`,`invoic_date`,`voucer_no`,`voucer_date`,`total_amount`,`total-discount`,`net_total_amount`,`paid`,`due`,session_id, total_item)"
                    + "VALUES('"+jTextField1.getText()+"',CURDATE(),'"+jTextField3.getText()+"','"+thisDate+"','"+jTextField10.getText()+"','"+jTextField11.getText()+"','"+jTextField12.getText()+"',"
                    + " '"+jTextField13.getText()+"','"+jTextField14.getText()+"','"+jTextField1.getText()+"','"+jTextField5.getText()+"')";
            post = con.prepareStatement(query);
            post.execute();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, "Failed",JOptionPane.WARNING_MESSAGE
            );
        }
    }
    public void entry(){
        try {
            String query= "SELECT * FROM `curent_purches_table`";
            post =con.prepareStatement(query);
            result = post.executeQuery();
            while(result.next()){
            String query1 = "INSERT INTO `purches_entry`(`id`,`product_id`,`quantity`,"
                    + "`purches_price`,`discount`,`total_price`,`sale_price`,`session_id`,`create_at`) "
                    + "VALUES ('"+result.getString("id")+"','"+result.getString("Product_Id")+"',"
                    + "'"+result.getString("Quantity")+"','"+result.getString("Purches_Price")+"','"+result.getString("Discount")+"',"
                    + " '"+result.getString("Total_Price")+"','"+result.getString("Sale_Price_Per")+"','"+result.getString("Session")+"',CURRENT_TIMESTAMP())";
            post =con.prepareStatement(query1);
            post.execute();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, "Failed",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void current_stock(){
        try {
          String query= "SELECT * FROM `curent_purches_table`";
          post = con.prepareStatement(query);
          result =post.executeQuery();
          
          
          while(result.next()){
          String query1 ="SELECT * FROM `stocks` WHERE `product_id` ='"+result.getString("Product_Id")+"'";
          post = con.prepareStatement(query1);
          resuilt2 = post.executeQuery();
         
          
          if(resuilt2.next()){
          String query2 ="UPDATE `stocks` SET `Quantity`=`Quantity`+   '"+result.getString("Quantity")+"' WHERE  `product_id` ='"+resuilt2.getString("product_id")+"'  ";
          post = con.prepareStatement(query2);
          post.execute();
          
          }
          else{
              String query3 ="INSERT INTO `stocks`(`product_id`,`Product_Name`,`Quantity`,`Purches_price`,`Sale_price`,`Masuerment_unit`)"
                      + " VALUES('"+result.getString("Product_Id")+"','"+result.getString("Product_name")+"','"+result.getString("Quantity")+"',"
                      + " '"+result.getString("Purches_Price")+"','"+result.getString("Sale_Price_Per")+"',"
                      + " '"+result.getString("Product_Unit")+"')";
              post = con.prepareStatement(query3);
              post.execute();
              
          }
          
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");
            e.printStackTrace();
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
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kButton1 = new keeptoo.KButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kButton7 = new keeptoo.KButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        kButton8 = new keeptoo.KButton();
        kButton9 = new keeptoo.KButton();
        kButton10 = new keeptoo.KButton();

        setBorder(null);
        setClosable(true);
        setTitle("Purches Info");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice", "Product_Id", "Unit", "Quantity", "Purches_Price", "Discount", "Total price", "Sale price", "Session"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        kGradientPanel1.setkBorderRadius(40);
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 153, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Invoice No:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Suppliar Phone");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Select Suppliar");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Suppliar" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Voucer No");

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select product" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Voucer Date");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Expire Date");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Var Code");

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Unit" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Purches Price");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Total Price");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Discount");

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Sale Price (per Unit)");

        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(153, 153, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 204, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton1.setkIndicatorThickness(1);
        kButton1.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton1.setkStartColor(new java.awt.Color(102, 204, 255));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("product name");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField15))
                        .addGap(18, 18, 18)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel12)))
                        .addGap(27, 27, 27))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 177, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49))))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 153, 255));

        kButton7.setText("Final Details");
        kButton7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton7.setkEndColor(new java.awt.Color(153, 153, 255));
        kButton7.setkHoverEndColor(new java.awt.Color(255, 204, 255));
        kButton7.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton7.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton7.setkIndicatorThickness(1);
        kButton7.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton7.setkStartColor(new java.awt.Color(102, 204, 255));
        kButton7.setOpaque(false);

        jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField10.setText("Total Amount");
        jTextField10.setBorder(null);
        jTextField10.setOpaque(false);
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

        jTextField11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField11.setText("Discount");
        jTextField11.setBorder(null);
        jTextField11.setOpaque(false);
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11MouseClicked(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField12.setText("Net Total");
        jTextField12.setBorder(null);
        jTextField12.setOpaque(false);
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField13.setText("Paid Amount");
        jTextField13.setBorder(null);
        jTextField13.setOpaque(false);
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });

        jTextField14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField14.setText("Due");
        jTextField14.setBorder(null);
        jTextField14.setOpaque(false);

        jSeparator1.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator5.setBackground(new java.awt.Color(102, 102, 255));

        kButton8.setText("Submit");
        kButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton8.setkEndColor(new java.awt.Color(153, 153, 255));
        kButton8.setkHoverEndColor(new java.awt.Color(255, 204, 255));
        kButton8.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton8.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton8.setkIndicatorThickness(1);
        kButton8.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton8.setkStartColor(new java.awt.Color(102, 204, 255));
        kButton8.setOpaque(false);
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        kButton9.setText("Clear");
        kButton9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton9.setkEndColor(new java.awt.Color(153, 153, 255));
        kButton9.setkHoverEndColor(new java.awt.Color(255, 204, 255));
        kButton9.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton9.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton9.setkIndicatorThickness(1);
        kButton9.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton9.setkStartColor(new java.awt.Color(102, 204, 255));
        kButton9.setOpaque(false);
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });

        kButton10.setText("Clear Shoping Card");
        kButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kButton10.setkEndColor(new java.awt.Color(153, 153, 255));
        kButton10.setkHoverEndColor(new java.awt.Color(255, 204, 255));
        kButton10.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton10.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton10.setkIndicatorThickness(1);
        kButton10.setkSelectedColor(new java.awt.Color(255, 153, 153));
        kButton10.setkStartColor(new java.awt.Color(102, 204, 255));
        kButton10.setOpaque(false);
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextField10.setText("Total Amount");
        jTextField11.setText("Discount");
        jTextField12.setText("Net Total");
        jTextField13.setText("Paid Amount");
        jTextField14.setText("Due");

    }//GEN-LAST:event_kButton9ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        Insert();
        TableView();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        SelectRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        if (jTextField10.getText().equals("Total Amount")) {
            jTextField10.setText(null);

        }
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        if (jTextField10.getText().equals("Total Amount")) {
            jTextField10.setText(null);

        }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        if (jTextField10.getText().equals("")) {
            jTextField10.setText("Total Amount");

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField11.requestFocus();

        }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {
            String getproduct = jComboBox2.getSelectedItem().toString();
            String query = "SELECT * FROM `product` WHERE product_name='" + getproduct + "' ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            if (result.next()) {
                proid = result.getString("Id");
                jComboBox3.setSelectedItem(result.getString("Masuerment"));
                jTextField15.setText("product_name");
                jTextField5.setText("1");
                jTextField8.setText("0.00");
                jTextField6.setText(result.getString("Purches_price"));
                jTextField9.setText(result.getString("Sale_price"));
                jTextField7.setText(result.getString("Purches_price"));
                var = Double.parseDouble(jTextField7.getText());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            String getname = jComboBox1.getSelectedItem().toString();
            String query = "SELECT `Suppliar_number` FROM `suppliar` WHERE Name  ='" + getname + "' ";
            post = con.prepareStatement(query);
            result = post.executeQuery();
            if (result.next()) {
                jTextField2.setText(result.getString("Suppliar_number"));

            }
        } catch (Exception e) 
        {
        }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        try {
            double quantity = Double.parseDouble(jTextField5.getText());
            double purchesprice = Double.parseDouble(jTextField6.getText());
            double results = quantity * purchesprice;

            jTextField7.setText(String.valueOf(results));
            var = Double.parseDouble(jTextField7.getText());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try {

            double var2 = Double.parseDouble(jTextField8.getText());
            double results = var - var2;
            jTextField7.setText(String.valueOf(results));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        if (jTextField8.getText().equals("0.00")) {
            jTextField8.setText(null);
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        clearShoppingcard();
        TableView();
    }//GEN-LAST:event_kButton10ActionPerformed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        try {
            double total = Double.parseDouble(jTextField10.getText());
            double discount = Double.parseDouble(jTextField11.getText());
            double result = total - discount;
            jTextField12.setText(String.valueOf(result));
            
        } catch (Exception e) {
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField12.requestFocus();

        }
        
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        try {
            double nettotal = Double.parseDouble(jTextField12.getText());
            double paid = Double.parseDouble(jTextField13.getText());
            double result = nettotal-paid;
            jTextField14.setText(String.valueOf(result));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseClicked
        if(jTextField11.getText().equals("Discount")){
            jTextField11.setText(null);
        
        }
    }//GEN-LAST:event_jTextField11MouseClicked

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField13.requestFocus();

        }
    }//GEN-LAST:event_jTextField12KeyReleased

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        leger();
        entry();
        current_stock();
    }//GEN-LAST:event_kButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
