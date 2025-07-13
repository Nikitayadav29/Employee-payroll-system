import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Employee{
private String name;
private  int id;

 public  Employee(String name, int id){
 this.name= name;
 this.id = id;
 }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
 class FulltimeEmployee extends Employee{
private double monthlySalary;
public FulltimeEmployee(String name,int id, double monthlySalary){
    super(name,id);
    this.monthlySalary = monthlySalary;
}
@Override
public double calculateSalary(){
    return monthlySalary;
}
 }
 class partTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyrate;
    public partTimeEmployee(String name,int id, int hoursworked, double hourlyrate){
    super(name,id);
    this.hoursworked=hoursworked;
    this.hourlyrate=hourlyrate;
    }
    @Override
    public double calculateSalary(){
        return hoursworked *hourlyrate;
    }
 }
 class payrollsystem {
    private ArrayList<Employee> EmployeeList;
    public payrollsystem(){
        EmployeeList = new ArrayList<>();
    }
     public void addEmployee(Employee employee) {
         EmployeeList.add(employee);
     }

     public void removeEmployee(int id) {
         Employee employeeToRemove = null;
         for (Employee employee : EmployeeList) {
             if (employee.getId() == id) {
                 employeeToRemove = employee;
                 break;
             }
         }
         if (employeeToRemove != null) {
             EmployeeList.remove(employeeToRemove);
         }
     }
     public void displayEmployees() {
         for (Employee employee : EmployeeList) {
             System.out.println(employee);
         }
     }
 }


public class Main {
    public static void main(String[] args) {
        payrollsystem payrollSystem = new payrollsystem();

        FulltimeEmployee emp1 = new  FulltimeEmployee("VIKAS", 1, 5000.0);
        partTimeEmployee  emp2 = new partTimeEmployee ("Alexandar", 2, 30, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("Removing Employee...");
        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details:");
        payrollSystem.displayEmployees();

    }
}