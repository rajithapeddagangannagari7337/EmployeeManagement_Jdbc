import dao.EmployeeDao;
import model.Employee;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EmployeeDao dao=new EmployeeDao();
        while (true){
            System.out.println("===Employee Management System===");
            System.out.println("1.Add Employee");
            System.out.println("2.View Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("Exit");

            System.out.println("Enter Your Choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Name");
                    String name=sc.nextLine();
                    System.out.println("Enter Email");
                    String email=sc.nextLine();
                    System.out.println("Enter Department");
                    String dept=sc.nextLine();
                    System.out.println("Enter Salary");
                    double sal=sc.nextDouble();

                    Employee emp=new Employee();
                    emp.setName(name);
                    emp.setEmail(email);
                    emp.setDepartment(dept);
                    emp.setSalary(sal);

                    dao.addEmployee(emp);
                    break;
                case 2:
                    dao.viewEmployee();
                    break;
                case 3:
                    System.out.println("Enter Employee ID to update");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    String newName= sc.nextLine();

                    Employee e=new Employee();
                    e.setId(id);
                    e.setName(newName);

                    dao.updateEmployee(e);
                    break;
                case 4:
                    System.out.println("Enter id to delete");
                    int id1=sc.nextInt();
                    Employee e1=new Employee();
                    e1.setId(id1);
                    dao.deleteEmployee(e1);
                    break;
                case 5:
                    System.out.println("5.Exit...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");

            }

        }
    }
}
