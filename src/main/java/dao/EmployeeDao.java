package dao;

import DBUtil.DBConnection;
import model.Employee;

import java.sql.*;

public class EmployeeDao {
    Connection con= DBConnection.getConnection();
    public void addEmployee(Employee emp){
        try {
            String sql="INSERT INTO employee(name,email,department,salary) values(?,?,?,?)";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, emp.getName());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getDepartment());
            pstm.setDouble(4,emp.getSalary());
            pstm.executeUpdate();
            System.out.println("Employee Details Added Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewEmployee(){
        String sql1="SELECT * FROM employee";
        try {
            PreparedStatement pstm1=con.prepareStatement(sql1);
            ResultSet rs=pstm1.executeQuery();
            while (rs.next()){
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " "+
                                rs.getString("department") + " " +
                                rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEmployee(Employee emp){
        String sql2="UPDATE employee SET name=? where id=?";
        try {
            PreparedStatement pstm2=con.prepareStatement(sql2);
            pstm2.setString(1,emp.getName());
            pstm2.setInt(2,emp.getId());
            pstm2.executeUpdate();
            System.out.println("Employee Details Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(Employee emp){
        String sql3="DELETE FROM employee where id=?";
        try {
            PreparedStatement pstm3=con.prepareStatement(sql3);
            pstm3.setInt(1,emp.getId());
            pstm3.executeUpdate();
            System.out.println("Employee Details Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
