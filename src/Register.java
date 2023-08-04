import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.awt.*;
public class Register extends javax.swing.JFrame {

 public Register() {
 initComponents();
 setTitle("Register");
 emp.setSelected(true);

 }

 private void initComponents() {
 buttonGroup1 = new javax.swing.ButtonGroup();
 jPanel1 = new javax.swing.JPanel();
 emp = new javax.swing.JRadioButton();
 admin = new javax.swing.JRadioButton();
 jLabel1 = new javax.swing.JLabel();
 jLabel2 = new javax.swing.JLabel();
 jLabel3 = new javax.swing.JLabel();
 JT1 = new javax.swing.JTextField();
 jButton1 = new javax.swing.JButton();
 jLabel4 = new javax.swing.JLabel();
 jButton2 = new javax.swing.JButton();
 JPF1 = new javax.swing.JPasswordField();
 JPF2 = new javax.swing.JPasswordField();
 jLabel5 = new javax.swing.JLabel();
 jLabel6 = new javax.swing.JLabel();
 phn = new javax.swing.JTextField();
 em = new javax.swing.JTextField();
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 buttonGroup1.add(emp);
 emp.setText("Employee");
 buttonGroup1.add(admin);
 admin.setText("Admin");
 admin.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 adminActionPerformed(evt);
 }
 });
 jLabel1.setText("Username");
 jLabel2.setText("Password");
 jLabel3.setText("Confirm Password");
 JT1.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 JT1ActionPerformed(evt);
 }
 });
 jButton1.setText("Register");
 jButton1.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 jButton1ActionPerformed(evt);
 }
 });
 jLabel4.setText("Already A User?");
 jButton2.setText("Sign in");
 jButton2.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 jButton2ActionPerformed(evt);
 }
 });
 jLabel5.setText("Phone no.");
 jLabel6.setText("Email");
 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
 jPanel1.setLayout(jPanel1Layout);
 jPanel1Layout.setHorizontalGroup(
 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
jPanel1Layout.createSequentialGroup()
 .addGap(0, 0, Short.MAX_VALUE)
 .addComponent(jLabel4)
 .addGap(18, 18, 18)
 .addComponent(jButton2)
 .addGap(46, 46, 46))
 .addGroup(jPanel1Layout.createSequentialGroup()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addGap(94, 94, 94)
 .addComponent(jButton1))
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addContainerGap()
 .addComponent(jLabel1)))
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addContainerGap()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(jPanel1Layout.createSequentialGroup()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(emp)
 .addComponent(jLabel2))
 .addGap(15, 15, 15)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addComponent(admin)
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
jPanel1Layout.createSequentialGroup()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addGap(0, 38, Short.MAX_VALUE)
 .addComponent(JPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
 .addComponent(JPF1)
 .addComponent(JT1)
 .addComponent(phn, javax.swing.GroupLayout.DEFAULT_SIZE, 130,
Short.MAX_VALUE)
 .addComponent(em))))
 .addGap(65, 65, 65))))
 .addGroup(jPanel1Layout.createSequentialGroup()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel5)
 .addComponent(jLabel6)
 .addComponent(jLabel3))
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
 );
 jPanel1Layout.setVerticalGroup(
 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(jPanel1Layout.createSequentialGroup()
 .addContainerGap()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(emp)
 .addComponent(admin))
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel1)
 .addComponent(JT1, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel5)
 .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel6)
 .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel2)
 .addComponent(JPF1, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel3)
 .addComponent(JPF2, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44,
Short.MAX_VALUE)
 .addComponent(jButton1)
 .addGap(18, 18, 18)

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel4)
 .addComponent(jButton2))
 .addGap(60, 60, 60))
 );
 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 getContentPane().setLayout(layout);
 layout.setHorizontalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addContainerGap())
 );
 layout.setVerticalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addContainerGap())
 );
 pack();
 }// </editor-fold>
 private void JT1ActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 }
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 DBConnect c = new DBConnect();
 String pri;
 String pass = JPF1.getText();
 String pass1 = JPF2.getText();
 if(admin.isSelected()){
 pri = "Admin";
 }
 else{
 pri = "Employee";
 }

 if(pass.equals(pass1))
 {
 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "insert into users (Username, Phone_no, Email, Privilege, Password) values ('"+ JT1.getText() +"','"+ phn.getText() +"', '"+ em.getText() +"','"+ pri +"','"+ pass1 +"')";
 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());

 if(q.executeUpdate() == 1) {
 JOptionPane.showMessageDialog(null, "Registration Successful");
 }else{
 JOptionPane.showMessageDialog(null, "Registration Unsuccessful");
 }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, "Registration Successful");
 }

 }else{
 JOptionPane.showMessageDialog(null, "Passwords Do Not Match!","Error",2);
 }
 }
 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 new Login().setVisible(true);
 dispose();
 }
 private void adminActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 String Pass = JOptionPane.showInputDialog("Enter Admins Password");
 if("admin".equals(Pass))
 {
 admin.setSelected(true);
 }
 else
 {
 JOptionPane.showMessageDialog(null, "Access Denied");
 emp.setSelected(true);
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

java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
ex);
 } catch (InstantiationException ex) {

java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
ex);
 } catch (IllegalAccessException ex) {

java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
ex);
 } catch (javax.swing.UnsupportedLookAndFeelException ex) {

java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null,
ex);
 }
 /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new Register().setVisible(true);
 }
 })
 // Variables declaration - do not modify
 private javax.swing.JPasswordField JPF1;
 private javax.swing.JPasswordField JPF2;
 private javax.swing.JTextField JT1;
 private javax.swing.JRadioButton admin;
 private javax.swing.ButtonGroup buttonGroup1;
 private javax.swing.JTextField em;
 private javax.swing.JRadioButton emp;
 private javax.swing.JButton jButton1;
 private javax.swing.JButton jButton2;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JLabel jLabel5;
 private javax.swing.JLabel jLabel6;
 private javax.swing.JPanel jPanel1;
 private javax.swing.JTextField phn;
 }