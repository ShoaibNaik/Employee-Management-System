import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class AdminPanel extends javax.swing.JFrame {

 DBConnect c = new DBConnect();
 public AdminPanel() {
 initComponents();
 setTitle("Admin Panel");
 }

 public ArrayList<Admin> AdminList(){
 ArrayList<Admin> AdminList = new ArrayList<>();

 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");
 
 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "select * from Admin";
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
 DefaultTableModel model = (DefaultTableModel)AdminTable.getModel();
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
 DefaultTableModel model = (DefaultTableModel)AdminTable.getModel();
 model.setRowCount(0);
 }

 private void initComponents() {
 jLabel1 = new javax.swing.JLabel();
 jLabel2 = new javax.swing.JLabel();
 jLabel3 = new javax.swing.JLabel();
 jLabel4 = new javax.swing.JLabel();
 jLabel5 = new javax.swing.JLabel();
 jLabel6 = new javax.swing.JLabel();
 txtid = new javax.swing.JTextField();
 txtname = new javax.swing.JTextField();
 txtphn = new javax.swing.JTextField();
 txtemail = new javax.swing.JTextField();
 txtadd = new javax.swing.JTextField();
 txtsal = new javax.swing.JTextField();
 Insert = new javax.swing.JButton();
 Update = new javax.swing.JButton();
 Delete = new javax.swing.JButton();
 Refresh = new javax.swing.JButton();
 jScrollPane1 = new javax.swing.JScrollPane();
 AdminTable = new javax.swing.JTable();
 Salarybtn = new javax.swing.JButton();
 Logout = new javax.swing.JButton();
 View = new javax.swing.JButton();
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 jLabel1.setText("ID");
 jLabel2.setText("Name");
 jLabel3.setText("Phone no.");
 jLabel4.setText("Email");
 jLabel5.setText("Address");
 jLabel6.setText("Salary");
 Insert.setText("Insert");
 Insert.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 InsertActionPerformed(evt);
 }
 });
 Update.setText("Update");
 Update.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 UpdateActionPerformed(evt);
 }
 });
 Delete.setText("Delete");
 Delete.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 DeleteActionPerformed(evt);
 }
 });
 Refresh.setText("Refresh");
 Refresh.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 RefreshActionPerformed(evt);
 }
 });
 AdminTable.setModel(new javax.swing.table.DefaultTableModel(
 new Object [][] {
 },
 new String [] {
 "Emp ID", "Name", "Phone_no", "Email", "Address", "Salary"
 }
 ));
 AdminTable.addMouseListener(new java.awt.event.MouseAdapter() {
 public void mouseClicked(java.awt.event.MouseEvent evt) {
 AdminTableMouseClicked(evt);
 }
 });
 jScrollPane1.setViewportView(AdminTable);
 Salarybtn.setText("Salary");
 Salarybtn.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 SalarybtnActionPerformed(evt);
 }
 });
 Logout.setText("Logout");
 Logout.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 LogoutActionPerformed(evt);
 }
 });
 View.setText("View");
 View.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 ViewActionPerformed(evt);
 }
 });
 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 getContentPane().setLayout(layout);
 layout.setHorizontalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel1)
 .addComponent(jLabel2))
 .addGap(40, 40, 40)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
 .addComponent(txtid)
 .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 120,
Short.MAX_VALUE)))
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel3)
 .addComponent(jLabel4)
 .addComponent(jLabel5)
 .addComponent(jLabel6))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(txtphn)
 .addComponent(txtemail)
 .addComponent(txtadd)
 .addComponent(txtsal)))
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
false)
 .addComponent(Insert, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53,
Short.MAX_VALUE)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
 .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539,
Short.MAX_VALUE)
 .addGroup(layout.createSequentialGroup()
 .addComponent(View, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addGap(399, 399, 399)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
 .addComponent(Salarybtn, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 70,
Short.MAX_VALUE))))
 .addContainerGap())
 );
 layout.setVerticalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGap(25, 25, 25)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel1)
 .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel2)
 .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel3)
 .addComponent(txtphn, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel4)
 .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel5)
 .addComponent(txtadd, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel6)
 .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(Insert)
 .addComponent(Update))
 .addGap(30, 30, 30)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(Delete)
 .addComponent(Refresh)))
 .addGroup(layout.createSequentialGroup()
 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(Salarybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
javax.swing.GroupLayout.PREFERRED_SIZE)))
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 );
 pack();
 }// </editor-fold>
 private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 new Login().setVisible(true);
 dispose();
 }
 private void InsertActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);

 String ssal = txtsal.getText();
 double sal = new Double(ssal);

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "insert into admin (EmpID, Name, Phone_no, Email, Address, Salary) values ('"+ id +"','"+ txtname.getText() +"','"+ txtphn.getText() +"', '"+ txtemail.getText() +"','"+
txtadd.getText() +"','"+ sal +"')";
 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());

 if(q.executeUpdate() == 1) {
 JOptionPane.showMessageDialog(null, "Details Added Successfully");
 }else{
 JOptionPane.showMessageDialog(null, "Details Not Added Successfully");
 }

 txtid.setText("");
 txtname.setText("");
 txtphn.setText("");
 txtemail.setText("");
 txtadd.setText("");
 txtsal.setText("");

 resetTable();
 showAdminTable();
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Details Added Successfully");
 }
 }
 private void ViewActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 showAdminTable();
 }
 private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 txtid.setText("");
 txtname.setText("");
 txtphn.setText("");
 txtemail.setText("");
 txtadd.setText("");
 txtsal.setText("");
 resetTable();
 showAdminTable();
 }
 private void AdminTableMouseClicked(java.awt.event.MouseEvent evt) {
 // TODO add your handling code here:
 int i = AdminTable.getSelectedRow();
 TableModel model = AdminTable.getModel();
 txtid.setText(model.getValueAt(i, 0).toString());
 txtname.setText(model.getValueAt(i, 1).toString());
 txtphn.setText(model.getValueAt(i, 2).toString());
 txtemail.setText(model.getValueAt(i, 3).toString());
 txtadd.setText(model.getValueAt(i, 4).toString());
 txtsal.setText(model.getValueAt(i, 5).toString());

 }
 private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:

 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);

 String ssal = txtsal.getText();
 double sal = new Double(ssal);

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "UPDATE Admin SET Name = '"+ txtname.getText() +"', Phone_no = '"+ txtphn.getText() +"', Email = '"+ txtemail.getText() +"',Address = '"+ txtadd.getText() +"', Salary = '"+sal +"' WHERE EmpID = '"+ id +"'";

 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());

 if(q.executeUpdate() == 1) {
 JOptionPane.showMessageDialog(null, "Details Updated Successfully");
 }else{
 JOptionPane.showMessageDialog(null, "Details Not Updated Successfully");
 }

 txtid.setText("");
 txtname.setText("");
 txtphn.setText("");
 txtemail.setText("");
 txtadd.setText("");
 txtsal.setText("");

 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
 }
 private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "DELETE From Admin WHERE EmpID = '"+ id +"'";
 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());

 if(q.executeUpdate() == 0) {
 JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
 }else{
 JOptionPane.showMessageDialog(null, "Details Not Deleted Successfully");
 }

 txtid.setText("");
 txtname.setText("");
 txtphn.setText("");
 txtemail.setText("");
 txtadd.setText("");
 txtsal.setText("");
 
 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
 }
 private void SalarybtnActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 new Salary().setVisible(true);
 dispose();
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

java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (InstantiationException ex) {

java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (IllegalAccessException ex) {

java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (javax.swing.UnsupportedLookAndFeelException ex) {

java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 }
 //</editor-fold>
 /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new AdminPanel().setVisible(true);
 }
 });
 }
 // Variables declaration - do not modify
 private javax.swing.JTable AdminTable;
 private javax.swing.JButton Delete;
 private javax.swing.JButton Insert;
 private javax.swing.JButton Logout;
 private javax.swing.JButton Refresh;
 private javax.swing.JButton Salarybtn;
 private javax.swing.JButton Update;
 private javax.swing.JButton View;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JLabel jLabel5;
 private javax.swing.JLabel jLabel6;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JTextField txtadd;
 private javax.swing.JTextField txtemail;
 private javax.swing.JTextField txtid;
 private javax.swing.JTextField txtname;
 private javax.swing.JTextField txtphn;
 private javax.swing.JTextField txtsal;
 // End of variables declaration
}