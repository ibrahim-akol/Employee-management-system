/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steve;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dj steve
 */
public class splash extends javax.swing.JFrame {

    Connection con;
    Statement st;
    
    public splash() {
        initComponents();
        
        con=Javaconnect.createDb();
       con= Javaconnect.connectDB();
       tables();
       new Thread(){
           public void run(){
           for(int i=0;i<101;i++){
               try{
                   sleep(200);
                   pb.setValue(i);
                   if(pb.getValue()<=25)
                       lab.setText("Initializing modules...");
                   else if(pb.getValue()<=50)
                       lab.setText("Turning on modules...");
                   else if(pb.getValue()<=75)
                        lab.setText("Loading modules...");
                   else if(pb.getValue()<=96)
                       lab.setText("Preparing Desktop application...");
                   else
                       lab.setText("Done Loading Modules");
                   
                       
               }catch(Exception ex){
                   
               }
           }close();
           new Login().setVisible(true);
                   
       }
       }.start();
        
    }
   public void close(){
        this.dispose();
    }
   public void tables(){
       try{
           String sql="CREATE TABLE IF NOT EXISTS login (usertype varchar(40),"
                   + "username varchar(30),"
                   + "password varchar(30) )";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
       try{
           String sql="CREATE TABLE IF NOT EXISTS activation (Id varchar(40))";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
        try{
           String sql="CREATE TABLE IF NOT EXISTS approve (Id varchar(40),"
                   + "dated varchar(70))";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
        
        try{
           String sql="Delete from login where username='admin'";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
        try{
           String sql="Insert into login values('Admin','admin','admin') ";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
      
      
        try{
           String sql="CREATE TABLE IF NOT EXISTS checkin (id varchar(40),"
                   + "username varchar(30),"
                   + "time_checked_in varchar(70),"
                   + "Date_checked_in varchar(30) )";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
        try{
           String sql="CREATE TABLE IF NOT EXISTS checkout (id varchar(40),"
                   + "username varchar(30),"
                   + "time_checked_out varchar(70),"
                   + "date_checked_out varchar(30) )";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
        try{
            String sql="CREATE TABLE IF NOT EXISTS Leave_request(id varchar(30),"
                    + "Firstname varchar(70),"
                    + "Work_position varchar(70),"
                    + "Phone varchar(15),"
                    + "Leave_type varchar(50),"
                    + "Leave_desc varchar(100),"
                    + "Last_day varchar(70),"
                    + "Return_date varchar(70),"
                    + "Total_days_off varchar(10),"
                    + "Period_desc varchar(100))";
            st=con.createStatement();
           st.execute(sql);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
       try{
           String sql="CREATE TABLE IF NOT EXISTS Register (id varchar(40) primary key NOT NULL,"
                   + "firstname varchar(40),"
                   + "lastname varchar(30),"
                   + "Gender varchar(10),"
                   + "Department varchar(30),"
                   + "work_position varchar(30),"
                   + "Username varchar(40),"
                   + "password varchar(40),"
                   + "Profile longblob,"
                   + "Phone varchar(15) )";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
       try{
           String sql="CREATE TABLE IF NOT EXISTS visitors(id varchar(40) NOT NULL primary key,"
                   + "Firstname varchar(30),"
                   + "Lastname_in varchar(30),"
                   + "mobile varchar(30),"
                   + "email varchar(50),"
                   + "gender varchar(10),"
                   + "Location varchar(30),"
                   + "address varchar(40),"
                   + "purpose varchar(100),"
                   + "Time_in varchar(70))";
           st=con.createStatement();
           st.execute(sql);
           
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pb = new javax.swing.JProgressBar();
        lab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Steve/images/khartoum logo.png"))); // NOI18N

        pb.setBackground(new java.awt.Color(0, 255, 51));

        lab.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lab.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 232, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(pb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(566, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lab;
    private javax.swing.JProgressBar pb;
    // End of variables declaration//GEN-END:variables
}
