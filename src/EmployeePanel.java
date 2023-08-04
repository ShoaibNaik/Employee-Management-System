import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class EmployeePanel extends javax.swing.JFrame {
 String lname;
 int EId;
 public EmployeePanel() {
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


 public void resetTable(){
 DefaultTableModel model = (DefaultTableModel)empTable.getModel();
 model.setRowCount(0);
 }
 private void initComponents() {
 jScrollPane1 = new javax.swing.JScrollPane();
 empTable = new javax.swing.JTable();
 txtid = new javax.swing.JTextField();
 txtname = new javax.swing.JTextField();
 txtphone = new javax.swing.JTextField();
 emp = new javax.swing.JLabel();
 jLabel2 = new javax.swing.JLabel();
 jLabel3 = new javax.swing.JLabel();
 jLabel4 = new javax.swing.JLabel();
 jLabel5 = new javax.swing.JLabel();
 search = new javax.swing.JButton();
 update = new javax.swing.JButton();
 logout = new javax.swing.JButton();
 txtemail = new javax.swing.JTextField();
 txtadd = new javax.swing.JTextField();
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 empTable.setModel(new javax.swing.table.DefaultTableModel(
 new Object [][] {
 },
 new String [] {
 "EmpID", "Name", "Phone_no", "Email", "Address","Salary"
 }
 ));
 empTable.addMouseListener(new java.awt.event.MouseAdapter() {
 public void mouseClicked(java.awt.event.MouseEvent evt) {
 empTableMouseClicked(evt);
 }
 });
 jScrollPane1.setViewportView(empTable);
 //jScrollPane1.setViewportView(salTable);
 emp.setText("EmpID");
 jLabel2.setText("Name");
 jLabel3.setText("Phone_no");
 jLabel4.setText("Email");
 jLabel5.setText("Address");
 search.setText("Search");
 search.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 searchActionPerformed(evt);
 }
 });
 update.setText("Update");
 update.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 updateActionPerformed(evt);
 }
 });
 logout.setText("Logout");
 logout.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 logoutActionPerformed(evt);
 }
 });
 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 getContentPane().setLayout(layout);
 layout.setHorizontalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
 .addContainerGap()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addComponent(search)
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103,Short.MAX_VALUE)
 .addComponent(update))
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGap(0, 0, Short.MAX_VALUE)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(emp)
 .addComponent(jLabel2)
 .addComponent(jLabel3))
 .addGap(49, 49, 49))
 .addGroup(layout.createSequentialGroup()

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel4)
 .addComponent(jLabel5))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
 .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 138,
Short.MAX_VALUE)
 .addComponent(txtid)
 .addComponent(txtphone, javax.swing.GroupLayout.Alignment.TRAILING)
 .addComponent(txtemail)
 .addComponent(txtadd))))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(logout, javax.swing.GroupLayout.Alignment.TRAILING)
 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461,
javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18))
 );
 layout.setVerticalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addGap(18, 18, 18)
 .addComponent(logout))
 .addGroup(layout.createSequentialGroup()
 .addGap(39, 39, 39)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(emp))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel2))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel3))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel4)
 .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel5)
 .addComponent(txtadd, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(30, 30, 30)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(update)
 .addComponent(search)))
 );
 pack();
 }// </editor-fold> 
 private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 new Login().setVisible(true);
 dispose();
 }
 private void searchActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 showAdminTable();
 
 }
 private void empTableMouseClicked(java.awt.event.MouseEvent evt) {
 // TODO add your handling code here:
 int i = empTable.getSelectedRow();
 TableModel model = empTable.getModel();
 //txtid.setText(model.getValueAt(i, 0).toString());
 txtname.setText(model.getValueAt(i, 1).toString());
 txtphone.setText(model.getValueAt(i, 2).toString());
 txtemail.setText(model.getValueAt(i, 3).toString());
 txtadd.setText(model.getValueAt(i, 4).toString());

 }
 private void updateActionPerformed(java.awt.event.ActionEvent evt) {
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
txtphone.getText() +"', Email = '"+ txtemail.getText() +"',Address = '"+ txtadd.getText() +"' WHERE EmpID = '"+ id +"'";
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
 txtadd.setText("");
 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
 }
 public static void main(String args[]) {
 try {
 for (javax.swing.UIManager.LookAndFeelInfo info :
javax.swing.UIManager.getInstalledLookAndFeels()) {
 if ("Nimbus".equals(info.getName())) {
 javax.swing.UIManager.setLookAndFeel(info.getClassName());
 break;
 }
 }
 } catch (ClassNotFoundException ex) {

java.util.logging.Logger.getLogger(EmployeePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
 } catch (InstantiationException ex) {

java.util.logging.Logger.getLogger(EmployeePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
 } catch (IllegalAccessException ex) {

java.util.logging.Logger.getLogger(EmployeePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
 } catch (javax.swing.UnsupportedLookAndFeelException ex) {

java.util.logging.Logger.getLogger(EmployeePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
 }
 //</editor-fold>
 /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new EmployeePanel().setVisible(true);
 }
 });
 }
 private javax.swing.JLabel emp;
 private javax.swing.JTable empTable;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JLabel jLabel5;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JButton logout;
 private javax.swing.JButton search;
 private javax.swing.JTextField txtadd;
 private javax.swing.JTextField txtemail;
 private javax.swing.JTextField txtid;
 private javax.swing.JTextField txtname;
 private javax.swing.JTextField txtphone;
 private javax.swing.JButton update;
 }