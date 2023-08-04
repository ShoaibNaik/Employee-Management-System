class Admin {

 private int EmpID;
 private String Name, Email, Address, Phone_no;
 private double Salary;

 public Admin(int EmpID, String Name, String Phone_no, String Email, String Address, double
Salary){
 this.EmpID = EmpID;
 this.Name = Name;
 this.Phone_no = Phone_no;
 this.Email = Email;
 this.Address = Address;
 this.Salary = Salary;
 }


 public int GetID(){
 return EmpID;
 }

 public String GetName(){
 return Name;
 }
 
 public String GetPhone(){
 return Phone_no;
 }

 public String GetEmail(){
 return Email;
 }

 public String GetAddress(){
 return Address;
 }

 public double GetSal(){
 return Salary;
 }
}