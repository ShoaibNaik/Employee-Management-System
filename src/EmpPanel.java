
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author shoai
 */
public class EmpPanel extends javax.swing.JFrame {

    /**
     * Creates new form EmpPanel
     */
    int EId;
    String lname;
    public EmpPanel() {
        initComponents();
        setTitle("Employee Panel");
    }

    public void EmployeePanel1(String name){
    this.lname = name;
    txtname.setText(lname);
    txtname.setEnabled(false);
    DBConnect c = new DBConnect();
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");

    c.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
    c.st = c.con.createStatement();
    String query = "select * from Admin where Name = '"+ lname +"'";
    c.rs = c.st.executeQuery(query);
    while(c.rs.next()){
    this.EId = c.rs.getInt("EmpID");
    System.out.println(EId);
    String id = String.valueOf(EId);
    txtid.setText(id);
    txtid.setEnabled(false);
    }
    }catch(Exception e){
    System.out.println("Error");
}
 }
 public ArrayList<Admin> AdminList(){
 ArrayList<Admin> AdminList = new ArrayList<>();
 DBConnect c = new DBConnect();
 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "select * from Admin where Name = '"+ lname +"'";
 c.rs = c.st.executeQuery(query);
 Admin Admin;

 while(c.rs.next()){

 Admin = new Admin(c.rs.getInt("EmpID"), c.rs.getString("Name"),
c.rs.getString("Phone_no"), c.rs.getString("Email"), c.rs.getString("Address"),
c.rs.getDouble("Salary"));
 AdminList.add(Admin);

 }

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
 }

 return AdminList;
 }


 public void showAdminTable(){
 ArrayList<Admin> list = AdminList();
 DefaultTableModel model = (DefaultTableModel)empTable.getModel();
 Object[] row = new Object[6];
 for(int i=0;i<list.size();i++){
 row[0] = list.get(i).GetID();
 row[1] = list.get(i).GetName();
 row[2] = list.get(i).GetPhone();
 row[3] = list.get(i).GetEmail();
 row[4] = list.get(i).GetAddress();
 row[5] = list.get(i).GetSal();
 model.addRow(row);
 }
 }

 public ArrayList<SalaryDataClass> SalaryList(){
 ArrayList<SalaryDataClass> SalaryList = new ArrayList<>();

 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanagement","root","");
 c.st = c.con.createStatement();
 String query = "select * from sal where EmpID = '"+ EId +"'";
 c.rs = c.st.executeQuery(query);
 SalaryDataClass sal;

 while(c.rs.next()){

 sal = new SalaryDataClass(c.rs.getInt("EmpID"), c.rs.getString("Name"),
c.rs.getDouble("Monthly_sal"), c.rs.getInt("Working_hours"), c.rs.getInt("Overtime_hours"),
c.rs.getDouble("Overtime_sal"),c.rs.getDouble("Overtime_cal"),c.rs.getDouble("Actual_sal"),c.rs.getDouble("Annual_sal"));
 SalaryList.add(sal);

 }

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
 }

 return SalaryList;
 }

 public void showAdminTable1(){
 ArrayList<SalaryDataClass> list = SalaryList();
 DefaultTableModel model = (DefaultTableModel)salTable.getModel();
 Object[] row = new Object[4];
 for(int i=0;i<list.size();i++){
 row[0] = list.get(i).GetOH();
 row[1] = list.get(i).GetOSal();
 row[2] = list.get(i).GetOCal();
 row[3] = list.get(i).GetAcSal();
 model.addRow(row);
 }
 }


 public void resetTable(){
 DefaultTableModel model = (DefaultTableModel)empTable.getModel();
 model.setRowCount(0);
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        Search = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        salTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        l1.setText("EmpID");

        l2.setText("Name");

        l3.setText("Phone_no");

        l4.setText("Email");

        l5.setText("Address");

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmpID", "Name", "Phone_no", "Email", "Address", "Salary"
            }
        ));
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);

        Search.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        salTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Overtime_hours", "Overtime_sal", "Overtime_cal", "Actual_sal"
            }
        ));
        jScrollPane2.setViewportView(salTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l1)
                            .addComponent(l2)
                            .addComponent(l3)
                            .addComponent(l4)
                            .addComponent(l5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Update)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Logout))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l1)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l2)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l5)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search)
                    .addComponent(Update)
                    .addComponent(Logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        l1.getAccessibleContext().setAccessibleName("EmpID");
        l5.getAccessibleContext().setAccessibleName("Address");
        Search.getAccessibleContext().setAccessibleName("Search");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        showAdminTable();
        showAdminTable1();
    }//GEN-LAST:event_SearchActionPerformed

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        // TODO add your handling code here:
        int i = empTable.getSelectedRow();
        TableModel model = empTable.getModel();
        //txtid.setText(model.getValueAt(i, 0).toString());
        txtname.setText(model.getValueAt(i, 1).toString());
        txtphone.setText(model.getValueAt(i, 2).toString());
        txtemail.setText(model.getValueAt(i, 3).toString());
        txtaddress.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_empTableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);
 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "UPDATE Admin SET Name = '"+ txtname.getText() +"', Phone_no = '"+
txtphone.getText() +"', Email = '"+ txtemail.getText() +"',Address = '"+ txtaddress.getText() +"' WHERE EmpID = '"+ id +"'";
 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());

 if(q.executeUpdate() == 1) {
 JOptionPane.showMessageDialog(null, "Details Updated Successfully");
 }else{
 JOptionPane.showMessageDialog(null, "Details Not Updated Successfully");
 }

 txtid.setText("");
 txtphone.setText("");
 txtemail.setText("");
 txtaddress.setText("");
 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
    }//GEN-LAST:event_UpdateActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
    dispose();
    }//GEN-LAST:event_LogoutActionPerformed
    

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
    private javax.swing.JTable empTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JTable salTable;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
