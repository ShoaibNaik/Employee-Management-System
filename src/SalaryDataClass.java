public class SalaryDataClass {

 private int EmpID, Working_hours, Overtime_hours;
 private String Name;
 private double Monthly_sal, Overtime_sal, Overtime_cal, Actual_sal, Annual_sal;

 public SalaryDataClass(int EmpID, String Name,double Monthly_sal, int Working_hours, int
Overtime_hours, double Overtime_sal, double Overtime_cal, double Actual_sal, double Annual_sal)
 {
 this.EmpID = EmpID;
 this.Name = Name;
 this.Monthly_sal = Monthly_sal;
 this.Working_hours = Working_hours;
 this.Overtime_hours = Overtime_hours;
 this.Overtime_sal = Overtime_sal;
 this.Overtime_cal = Overtime_cal;
 this.Actual_sal = Actual_sal;
 this.Annual_sal = Annual_sal;
 }

 public int GetID(){
 return EmpID;
 }

 public String GetName(){
 return Name;
 }

 public double GetMSal(){
 return Monthly_sal;
 }

 public int GetWH(){
 return Working_hours;
 }

 public int GetOH(){
 return Overtime_hours;
 }

 public double GetOSal(){
 return Overtime_sal;
 }

 public double GetOCal(){
 return Overtime_cal;
 }

 public double GetAcSal(){
 return Actual_sal;
 }

 public double GetAnSal(){
 return Annual_sal;
 }
}