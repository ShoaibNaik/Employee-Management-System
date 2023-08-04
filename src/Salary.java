import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class Salary extends javax.swing.JFrame {
 public Salary() {
 initComponents();
 setTitle("Salary Panel");
 }

 public ArrayList<SalaryDataClass> SalaryList(){
 ArrayList<SalaryDataClass> SalaryList = new ArrayList<>();

 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanagement","root","");
 c.st = c.con.createStatement();
 String query = "select * from sal";
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

 public void showAdminTable(){
 ArrayList<SalaryDataClass> list = SalaryList();
 DefaultTableModel model = (DefaultTableModel)salTable.getModel();
 Object[] row = new Object[9];
 for(int i=0;i<list.size();i++){
 row[0] = list.get(i).GetID();
 row[1] = list.get(i).GetName();
 row[2] = list.get(i).GetMSal();
 row[3] = list.get(i).GetWH();
 row[4] = list.get(i).GetOH();
 row[5] = list.get(i).GetOSal();
 row[6] = list.get(i).GetOCal();
 row[7] = list.get(i).GetAcSal();
 row[8] = list.get(i).GetAnSal();
 model.addRow(row);
 }
 }
 public void resetTable(){
 DefaultTableModel model = (DefaultTableModel)salTable.getModel();
 model.setRowCount(0);
 }
 private void initComponents() {
 jScrollPane1 = new javax.swing.JScrollPane();
 salTable = new javax.swing.JTable();
 jLabel1 = new javax.swing.JLabel();
 jLabel2 = new javax.swing.JLabel();
 jLabel3 = new javax.swing.JLabel();
 jLabel4 = new javax.swing.JLabel();
 jLabel5 = new javax.swing.JLabel();
 txtid = new javax.swing.JTextField();
 txtname = new javax.swing.JTextField();
 txtsal = new javax.swing.JTextField();
 txtwh = new javax.swing.JTextField();
 txtoh = new javax.swing.JTextField();
 jLabel6 = new javax.swing.JLabel();
 jLabel7 = new javax.swing.JLabel();
 jLabel8 = new javax.swing.JLabel();
 jLabel9 = new javax.swing.JLabel();
 txtosal = new javax.swing.JTextField();
 txtocal = new javax.swing.JTextField();
 txtacsal = new javax.swing.JTextField();
 txtansal = new javax.swing.JTextField();
 Insert = new javax.swing.JButton();
 update = new javax.swing.JButton();
 delete = new javax.swing.JButton();
 calculate = new javax.swing.JButton();
 view = new javax.swing.JButton();
 Refresh = new javax.swing.JButton();
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 salTable.setModel(new javax.swing.table.DefaultTableModel(
 new Object [][] {
 },
 new String [] {
 "EmpID", "Name", "Monthly_sal", "Working_hours", "Overtime_hours", "Overtime_sal",
"Overtime_cal", "Actual_sal", "Annual_sal"
 }
 ));
 salTable.addMouseListener(new java.awt.event.MouseAdapter() {
 public void mouseClicked(java.awt.event.MouseEvent evt) {
 salTableMouseClicked(evt);
 }
 });
 jScrollPane1.setViewportView(salTable);
 jLabel1.setText("EmpID");
 jLabel2.setText("Name");
 jLabel3.setText("Monthly_sal");
 jLabel4.setText("Working_hours");
 jLabel5.setText("Overtime_hours");
 txtid.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 txtidActionPerformed(evt);
 }
 });
 jLabel6.setText("Overtime_sal");
 jLabel7.setText("Overtime_cal");
 jLabel8.setText("Actual_sal");
 jLabel9.setText("Annual_sal");
 Insert.setText("Insert");
 Insert.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 InsertActionPerformed(evt);
 }
 });
 update.setText("Update");
 update.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 updateActionPerformed(evt);
 }
 });
 delete.setText("Delete");
 delete.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 deleteActionPerformed(evt);
 }
 });
 calculate.setText("Calculate");
 calculate.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 calculateActionPerformed(evt);
 }
 });
 view.setText("View");
 view.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 viewActionPerformed(evt);
 }
 });
 Refresh.setText("Refresh");
 Refresh.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 RefreshActionPerformed(evt);
 }
 });
 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 getContentPane().setLayout(layout);
 layout.setHorizontalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addContainerGap()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jScrollPane1)
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel4)
 .addComponent(jLabel5)
 .addComponent(jLabel3)
 .addComponent(jLabel2)
 .addComponent(jLabel1))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
 .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 130,
Short.MAX_VALUE)
 .addComponent(txtname)
 .addComponent(txtsal)
 .addComponent(txtwh)
 .addComponent(txtoh))
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGap(72, 72, 72)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
 .addComponent(jLabel6)
 .addComponent(jLabel7)))
 .addGroup(layout.createSequentialGroup()
 .addGap(75, 75, 75)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(jLabel9)
 .addComponent(jLabel8))))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
 .addComponent(txtosal, javax.swing.GroupLayout.DEFAULT_SIZE, 130,
Short.MAX_VALUE)
 .addComponent(txtocal)
 .addComponent(txtacsal)
 .addComponent(txtansal))
 .addGap(67, 67, 67)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addComponent(view, javax.swing.GroupLayout.Alignment.TRAILING,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)
 .addComponent(Insert, javax.swing.GroupLayout.Alignment.TRAILING,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)
 .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 73,
Short.MAX_VALUE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
 .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(calculate, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
 .addContainerGap())
 );
 layout.setVerticalGroup(
 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGap(26, 26, 26)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtosal, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel6)))
 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
 .addContainerGap()

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel1))))
 .addGap(18, 18, 18)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtocal, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel7))
 .addGap(18, 18, 18)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtacsal, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel8)))
 .addGroup(layout.createSequentialGroup()

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(jLabel2)
 .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE))
 .addGap(18, 18, 18)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel3))))
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 .addGroup(layout.createSequentialGroup()
 .addGap(18, 18, 18)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtansal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel9)))
 .addGroup(layout.createSequentialGroup()
 .addGap(18, 18, 18)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtwh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel4))
 .addGap(18, 18, 18)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(txtoh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(jLabel5)))))
 .addGroup(layout.createSequentialGroup()
 .addGap(32, 32, 32)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
 .addComponent(Insert, javax.swing.GroupLayout.DEFAULT_SIZE, 35,
Short.MAX_VALUE)
 .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 .addGap(11, 11, 11)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
 .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 35,
Short.MAX_VALUE)
 .addComponent(calculate, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
 .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
javax.swing.GroupLayout.PREFERRED_SIZE))))
 .addGap(21, 21, 21)
 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
javax.swing.GroupLayout.PREFERRED_SIZE)
 .addContainerGap(15, Short.MAX_VALUE))
 );
 pack();
 }// </editor-fold>
 private void txtidActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 }
 private void viewActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 resetTable();
 showAdminTable();
 }
 private void InsertActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);

 String Ahours = txtwh.getText();
 int ahours = Integer.parseInt(Ahours);

 String Ohours = txtoh.getText();
 int ohours = Integer.parseInt(Ohours);

 String ssal = txtsal.getText();
 double Msal = new Double(ssal);

 String Osal = txtosal.getText();
 double osal = new Double(Osal);

 String Ocal = txtocal.getText();
 double ocal = new Double(Ocal);

 String Acsal = txtacsal.getText();
 double acsal = new Double(Acsal);

 String Ansal = txtansal.getText();
 double ansal = new Double(Ansal);

 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanagement","root","");
 c.st = c.con.createStatement();
 String query = "insert into sal (EmpID, Name, Monthly_sal, Working_hours,Overtime_hours, Overtime_sal, Overtime_cal, Actual_sal, Annual_sal) values ('"+ id +"','"+txtname.getText() +"','"+ Msal +"', '"+ ahours +"','"+ ohours +"','"+ osal +"', '"+ ocal +"', '"+ acsal +"','"+ ansal +"')";
 PreparedStatement q = c.con.prepareStatement(query);

 q.executeUpdate();

 System.out.println(q.executeUpdate());
 
 if(q.executeUpdate() == 1) {
 JOptionPane.showMessageDialog(null, "Details Added Successfully");
 }else{
 JOptionPane.showMessageDialog(null, "Details Not Added Successfully");
 }


 }catch(Exception e){
 txtid.setText("");
 txtname.setText("");
 txtwh.setText("");
 txtoh.setText("");
 txtosal.setText("");
 txtsal.setText("");
 txtacsal.setText("");
 txtansal.setText("");
 txtocal.setText("");

 resetTable();
 showAdminTable();
 JOptionPane.showMessageDialog(null, "Details Added Successfully");
 }


 }
 private void updateActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);

 String Ahours = txtwh.getText();
 int ahours = Integer.parseInt(Ahours);

 String Ohours = txtoh.getText();
 int ohours = Integer.parseInt(Ohours);

 String ssal = txtsal.getText();
 double Msal = new Double(ssal);

 String Osal = txtosal.getText();
 double osal = new Double(Osal);

 String Ocal = txtocal.getText();
 double ocal = new Double(Ocal);

 String Acsal = txtacsal.getText();
 double acsal = new Double(Acsal);

 String Ansal = txtansal.getText();
 double ansal = new Double(Ansal);

 DBConnect c = new DBConnect();
 
 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanagement","root","");
 c.st = c.con.createStatement();
 String query = "UPDATE sal SET Name = '"+ txtname.getText() +"', Monthly_sal = '"+ Msal+"', Working_hours = '"+ ahours +"', Overtime_hours = '"+ ohours +"', Overtime_sal = '"+ osal +"',Overtime_cal = '"+ ocal +"', Actual_sal = '"+ acsal +"', Annual_sal = '"+ ansal +"' WHERE EmpID = '"+ id+"'";
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
 txtwh.setText("");
 txtoh.setText("");
 txtosal.setText("");
 txtsal.setText("");
 txtacsal.setText("");
 txtansal.setText("");
 txtocal.setText("");

 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
 }
 private void salTableMouseClicked(java.awt.event.MouseEvent evt) {
 // TODO add your handling code here:
 int i = salTable.getSelectedRow();
 TableModel model = salTable.getModel();
 txtid.setText(model.getValueAt(i, 0).toString());
 txtname.setText(model.getValueAt(i, 1).toString());
 txtsal.setText(model.getValueAt(i, 2).toString());
 txtwh.setText(model.getValueAt(i, 3).toString());
 txtoh.setText(model.getValueAt(i, 4).toString());
 txtosal.setText(model.getValueAt(i, 5).toString());
 txtocal.setText(model.getValueAt(i, 6).toString());
 txtacsal.setText(model.getValueAt(i, 7).toString());
 txtansal.setText(model.getValueAt(i, 8).toString());
 }
 private void deleteActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 String Eid = txtid.getText();
 int id = Integer.parseInt(Eid);
 DBConnect c = new DBConnect();

 try{
 Class.forName("com.mysql.jdbc.Driver");

 c.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
 c.st = c.con.createStatement();
 String query = "DELETE From sal WHERE EmpID = '"+ id +"'";
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
 txtwh.setText("");
 txtoh.setText("");
 txtosal.setText("");
 txtsal.setText("");
 txtacsal.setText("");
 txtansal.setText("");
 txtocal.setText("");

 resetTable();
 showAdminTable();

 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e, "Error", 2);
 }
 }
 private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 resetTable();
 showAdminTable();
 }
 private void calculateActionPerformed(java.awt.event.ActionEvent evt) {
 // TODO add your handling code here:
 String Ohours = txtoh.getText();
 int ohours = Integer.parseInt(Ohours);

 String ssal = txtsal.getText();
 double Msal = new Double(ssal);

 String Osal = txtosal.getText();
 double osal = new Double(Osal);

 double overCal = ohours * osal;
 String over_cal = String.valueOf(overCal);
 txtocal.setText(over_cal);

 double Ac_sal = Msal + overCal;
 String AcSAL = String.valueOf(Ac_sal);
 txtacsal.setText(AcSAL);

 double an_sal = Msal * 12;
 String An_sal = String.valueOf(an_sal);
 txtansal.setText(An_sal);
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
 java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (InstantiationException ex) {
 java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (IllegalAccessException ex) {
 java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 } catch (javax.swing.UnsupportedLookAndFeelException ex) {
 java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE,
null, ex);
 }
 //</editor-fold>
 /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new Salary().setVisible(true);
 }
 });
 }
 // Variables declaration - do not modify
 private javax.swing.JButton Insert;
 private javax.swing.JButton Refresh;
 private javax.swing.JButton calculate;
 private javax.swing.JButton delete;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JLabel jLabel5;
 private javax.swing.JLabel jLabel6;
 private javax.swing.JLabel jLabel7;
 private javax.swing.JLabel jLabel8;
 private javax.swing.JLabel jLabel9;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JTable salTable;
 private javax.swing.JTextField txtacsal;
 private javax.swing.JTextField txtansal;
 private javax.swing.JTextField txtid;
 private javax.swing.JTextField txtname;
 private javax.swing.JTextField txtocal;
 private javax.swing.JTextField txtoh;
 private javax.swing.JTextField txtosal;
 private javax.swing.JTextField txtsal;
 private javax.swing.JTextField txtwh;
 private javax.swing.JButton update;
 private javax.swing.JButton view;
 // End of variables declaration
}