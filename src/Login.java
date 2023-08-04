import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

 public Login() {
 initComponents();
 setTitle("Login");

 }

 private void initComponents() {
 jLabel1 = new javax.swing.JLabel();
 jLabel2 = new javax.swing.JLabel();
 jLabel3 = new javax.swing.JLabel();
 uname = new javax.swing.JTextField();
 pass = new javax.swing.JPasswordField();
 jButton1 = new javax.swing.JButton();
 jLabel4 = new javax.swing.JLabel();
 jButton2 = new javax.swing.JButton();
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
 jLabel1.setText("LOGIN");
 jLabel2.setText("Username");
 jLabel3.setText("Password");
 jButton1.setText("Login");
 jButton1.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 jButton1ActionPerformed(evt);
 }
 });
 jLabel4.setText("Not Registerd Yet?");
 jButton2.setText("Register");
 jButton2.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 jButton2ActionPerformed(evt);
 }
 });
 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 getContentPane().setLayout(layout);
 layout.setHorizontalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel2)
 .addComponent(jLabel3))
 .addGap(40, 40, 40)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
 .addComponent(uname)
 .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
 .addGroup(layout.createSequentialGroup()
 .addGap(8, 8, 8)
 .addComponent(jLabel1))))
 .addGroup(layout.createSequentialGroup()
 .addGap(82, 82, 82)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
 .addComponent(jLabel4)
 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
javax.swing.GroupLayout.PREFERRED_SIZE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 .addComponent(jButton2)))
 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 );
 layout.setVerticalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addComponent(jLabel1)
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel2)
 .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel3)
 .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(32, 32, 32)
 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
Short.MAX_VALUE)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel4)
 .addComponent(jButton2))
 .addContainerGap())
 );
 pack();
 }// </editor-fold>
 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 new Register().setVisible(true);
 dispose();
 }
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 DBConnect c = new DBConnect();
 String p = pass.getText();
 try{
 Class.forName("com.mysql.cj.jdbc.Driver");

 c.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpManagement","root","");
 c.st = c.con.createStatement();
 String query = "select * from users where Username = '"+ uname.getText() +"' and Password = '"+ p +"'";
 c.rs = c.st.executeQuery(query);

 if(c.rs.next()) {
 JOptionPane.showMessageDialog(null, "login Successful");
 String pri = c.rs.getString("Privilege");
 if("Admin".equals(pri)){
 new AdminPanel().setVisible(true);
 dispose();
 }else{
 EmpPanel e = new EmpPanel();
 e.setVisible(true);
 e.EmployeePanel1(uname.getText());
 dispose();

 }
 }else{
 JOptionPane.showMessageDialog(null, "login Unsuccessful");
 }
 }catch(Exception e){

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
 java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (InstantiationException ex) {
 java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (IllegalAccessException ex) {
 java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (javax.swing.UnsupportedLookAndFeelException ex) {
 java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 }
 //</editor-fold>
 /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new Login().setVisible(true);
 }
 });
 }
 // Variables declaration - do not modify
 private javax.swing.JButton jButton1;
 private javax.swing.JButton jButton2;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JPasswordField pass;
 private javax.swing.JTextField uname;
 // End of variables declaration
}