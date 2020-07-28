/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steve;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author dj steve
 */
public class VIEW_LEAVES extends javax.swing.JFrame {

   String username,ido;
   Connection con=Javaconnect.connectDB();
   Statement st;
   ResultSet rs;
   DefaultTableModel model,model2;
   PreparedStatement ps;
    public VIEW_LEAVES(String use) {
        initComponents();
        username=use;
        filldate();
        fillcombo();
        
        model=new DefaultTableModel(new String[]{"FirstName","Position","Leave","Leave date","Return date","Description"},0);
         model2=new DefaultTableModel(new String[]{"FirstName","Position","Leave","Leave date","Return date","Description"},0);
        table1.setModel(model);
        table2.setModel(model2);
        
        combo.setSelectedIndex(-1);
    }
   
    public void filldate(){
       try {
           String sql="select id from register where username=?";
           ps=con.prepareStatement(sql);
           ps.setString(1, username);
           rs=ps.executeQuery();
           if(rs.next()){
              ido=rs.getString("id");
           }
       } catch (SQLException ex) {
           Logger.getLogger(VIEW_LEAVES.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void filltable1(){
              String sql="Select * from leave_request where id=?";
    try {
       PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, ido);
        ResultSet rs1=ps.executeQuery();
        if(rs1.next()){
            model.addRow(new Object[]{rs1.getString("Firstname"),rs1.getString("Work_position"),rs1.getString("Leave_type"),rs1.getString("last_day"),rs1.getString("return_date"),rs1.getString("Leave_desc")});
        }
    } catch (Exception ex) {
       JOptionPane.showMessageDialog(null, ex);
    }
      
        
    }
     public void fillcombo(){
       try {
           String sql="Select * from approve where id=?";
        PreparedStatement ps2=con.prepareStatement(sql);
         ps2.setString(1, ido);
          ResultSet rs2=ps2.executeQuery();
           while(rs2.next()){
               combo.addItem(rs2.getString("dated"));
           }
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
       }
    }
public void notification(){
       try {
           String sql="select * from leave_request,approve where leave_request.id=? and approve.dated=? and leave_request.id=approve.id";
         PreparedStatement  ps=con.prepareStatement(sql);
           ps.setString(1, ido);
           ps.setString(2, combo.getSelectedItem().toString());
          ResultSet rs=ps.executeQuery();
           if(rs.next()){
                model2.addRow(new Object[]{rs.getString("leave_request.Firstname"),rs.getString("leave_request.Work_position"),rs.getString("leave_request.Leave_type"),rs.getString("leave_request.last_day"),rs.getString("leave_request.return_date"),rs.getString("leave_request.Leave_desc")});
           }
       } catch (SQLException ex) {
           Logger.getLogger(VIEW_LEAVES.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notification");

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table1);

        jButton2.setText("VIEW ALL LEAVES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aproved leave "));

        jLabel1.setText("Select Leave Application Date");

        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(646, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       model.setRowCount(0);
        filltable1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        model2.setRowCount(0);
        notification();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            JasperDesign jd=JRXmlLoader.load("src//leave2.jrxml");
            String sql="SELECT\n" +
"     approve.`Id` AS approve_Id,\n" +
"     approve.`dated` AS approve_dated,\n" +
"     leave_request.`id` AS leave_request_id,\n" +
"     leave_request.`Firstname` AS leave_request_Firstname,\n" +
"     leave_request.`Work_position` AS leave_request_Work_position,\n" +
"     leave_request.`Phone` AS leave_request_Phone,\n" +
"     leave_request.`Leave_type` AS leave_request_Leave_type,\n" +
"     leave_request.`Leave_desc` AS leave_request_Leave_desc,\n" +
"     leave_request.`Last_day` AS leave_request_Last_day,\n" +
"     leave_request.`Return_date` AS leave_request_Return_date,\n" +
"     leave_request.`Total_days_off` AS leave_request_Total_days_off,\n" +
"     leave_request.`Period_desc` AS leave_request_Period_desc\n" +
"FROM\n" +
"     `leave_request` leave_request INNER JOIN `approve` approve ON leave_request.`id` = approve.`Id`Where leave_request.id='"+ido+"' and approve.dated='"+combo.getSelectedItem()+"'";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sql);
            jd.setQuery(nq);
            JasperReport jasperReport=JasperCompileManager.compileReport(jd);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null,con);
            
            net.sf.jasperreports.view.JRViewer jv = new net.sf.jasperreports.view.JRViewer(jasperPrint);
            JFrame jf = new JFrame();
            jf.add(jv);
            jf.setTitle("Approved records");
            jf.setVisible(true);
            jv.setVisible(true);
            jv.setSize(700, 500);
            jv.setOpaque(true);
            jf.repaint();
            jf.validate();
            jf.setSize(new Dimension(720,520));
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VIEW_LEAVES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIEW_LEAVES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIEW_LEAVES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEW_LEAVES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new VIEW_LEAVES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
