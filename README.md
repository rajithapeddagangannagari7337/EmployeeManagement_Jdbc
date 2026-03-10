# Employee Management JDBC

A simple yet efficient Java-based employee management system using JDBC (Java Database Connectivity) to perform CRUD operations on employee records stored in a PostgreSQL database.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Installation & Setup](#installation--setup)
- [Database Configuration](#database-configuration)
- [Usage Guide](#usage-guide)
- [Code Examples](#code-examples)
- [Project Components](#project-components)
- [How It Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

This project is a command-line application that demonstrates the fundamentals of Java database programming using JDBC. It allows users to manage employee information with a simple menu-driven interface.

The system connects to a PostgreSQL database and provides functionality to add, view, update, and delete employee records efficiently.

---

## ✨ Features

- ✅ **Add Employee**: Insert new employee records into the database
- ✅ **View Employees**: Display all employee records with detailed information
- ✅ **Update Employee**: Modify employee information (name, email, department, salary)
- ✅ **Delete Employee**: Remove employee records from the database
- ✅ **Database Connectivity**: Secure connection management using JDBC
- ✅ **Error Handling**: Comprehensive exception handling for database operations
- ✅ **User-Friendly Menu**: Interactive console-based menu system

---

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Java 8 or higher
- **PostgreSQL**: Version 10 or higher
- **Maven**: Version 3.6.0 or higher (optional, for dependency management)
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE

### Required JDBC Driver
- **PostgreSQL JDBC Driver**: `postgresql-42.x.x.jar`

---

## 📁 Project Structure

```
EmployeeManagement_Jdbc/
│
├── src/
│   ├── DBUtil/
│   │   └── DBConnection.java          # Database connection utility
│   │
│   ├── model/
│   │   └── Employee.java              # Employee POJO class
│   │
│   ├── dao/
│   │   └── EmployeeDao.java           # Data Access Object for database operations
│   │
│   └── MainApp.java                   # Main application entry point
│
├── pom.xml                            # Maven configuration file
└── README.md                          # Project documentation
```

---

## 🛠️ Technologies Used

| Technology | Purpose | Version |
|-----------|---------|---------|
| **Java** | Core programming language | 8+ |
| **JDBC** | Database connectivity | Native |
| **PostgreSQL** | Relational Database | 10+ |
| **Maven** | Build & dependency management | 3.6.0+ |

---

## 🚀 Installation & Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/rajithapeddagangannagari7337/EmployeeManagement_Jdbc.git
cd EmployeeManagement_Jdbc
```

### Step 2: Install PostgreSQL

Download and install PostgreSQL from [postgresql.org](https://www.postgresql.org/download/)

Start the PostgreSQL server:
```bash
# On Windows
pg_ctl -D "C:\Program Files\PostgreSQL\data" start

# On macOS
brew services start postgresql

# On Linux
sudo service postgresql start
```

### Step 3: Download PostgreSQL JDBC Driver

Add the PostgreSQL JDBC driver to your project classpath:

```xml
<!-- In pom.xml -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.5.0</version>
</dependency>
```

Or manually download from [PostgreSQL Downloads](https://jdbc.postgresql.org/download/)

### Step 4: Create Database and Table

Connect to PostgreSQL and run the following SQL commands:

```sql
-- Create database
CREATE DATABASE emp;

-- Connect to the database
\c emp;

-- Create employee table
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);
```

### Step 5: Compile and Run

Using Maven:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="MainApp"
```

Or directly from IDE:
- Open the project in your IDE
- Right-click on `MainApp.java`
- Select "Run MainApp"

---

## 🔧 Database Configuration

The database connection is configured in `DBUtil/DBConnection.java`:

```java
private static String url="jdbc:postgresql://localhost:5432/emp";
private static String user="postgres";
private static String password="1234";
```

### Modify Connection Details:

Edit the credentials in `DBConnection.java` if your PostgreSQL setup is different:

| Parameter | Default | Description |
|-----------|---------|-------------|
| **url** | `jdbc:postgresql://localhost:5432/emp` | PostgreSQL connection URL |
| **user** | `postgres` | PostgreSQL username |
| **password** | `1234` | PostgreSQL password |
| **database** | `emp` | Database name |

---

## 📖 Usage Guide

### Running the Application

```bash
java -cp ".:postgresql-42.5.0.jar" MainApp
```

### Menu Options

```
===Employee Management System===
1. Add Employee
2. View Employee
3. Update Employee
4. Delete Employee
5. Exit
```

### Option 1: Add Employee
```
Enter Your Choice: 1
Enter Name: John Doe
Enter Email: john.doe@example.com
Enter Department: IT
Enter Salary: 50000
```
✅ Employee Details Added Successfully

### Option 2: View Employee
```
Enter Your Choice: 2
```
Output:
```
1 John Doe john.doe@example.com IT 50000.0
2 Jane Smith jane.smith@example.com HR 45000.0
```

### Option 3: Update Employee
```
Enter Your Choice: 3
Enter Employee ID to update: 1
Enter new name: Jonathan Doe
```
✅ Employee Details Updated Successfully

### Option 4: Delete Employee
```
Enter Your Choice: 4
Enter id to delete: 1
```
✅ Employee Details Deleted Successfully

### Option 5: Exit
```
Enter Your Choice: 5
5. Exit...
```

---

## 💻 Code Examples

### 1. DBConnection.java - Database Utility

```java
package DBUtil;

import java.sql.*;

public class DBConnection {
    private static String url="jdbc:postgresql://localhost:5432/emp";
    private static String user="postgres";
    private static String password="1234";
    
    public static Connection getConnection() {
        Connection con=null;
        try {
            // Step 1: Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");
            // Step 2: Create the connection
            con=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
```

### 2. Employee.java - Model Class

```java
package model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private double salary;

    public Employee() {}

    public Employee(int id, String name, String email, String department, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
```

### 3. EmployeeDao.java - Data Access Object

```java
package dao;

import DBUtil.DBConnection;
import model.Employee;
import java.sql.*;

public class EmployeeDao {
    Connection con = DBConnection.getConnection();
    
    public void addEmployee(Employee emp) {
        try {
            String sql = "INSERT INTO employee(name,email,department,salary) values(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, emp.getName());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getDepartment());
            pstm.setDouble(4, emp.getSalary());
            pstm.executeUpdate();
            System.out.println("Employee Details Added Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void viewEmployee() {
        String sql1 = "SELECT * FROM employee";
        try {
            PreparedStatement pstm1 = con.prepareStatement(sql1);
            ResultSet rs = pstm1.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("email") + " " +
                    rs.getString("department") + " " +
                    rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateEmployee(Employee emp) {
        String sql2 = "UPDATE employee SET name=? where id=?";
        try {
            PreparedStatement pstm2 = con.prepareStatement(sql2);
            pstm2.setString(1, emp.getName());
            pstm2.setInt(2, emp.getId());
            pstm2.executeUpdate();
            System.out.println("Employee Details Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteEmployee(Employee emp) {
        String sql3 = "DELETE FROM employee where id=?";
        try {
            PreparedStatement pstm3 = con.prepareStatement(sql3);
            pstm3.setInt(1, emp.getId());
            pstm3.executeUpdate();
            System.out.println("Employee Details Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### 4. MainApp.java - Main Application

```java
import dao.EmployeeDao;
import model.Employee;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDao();
        
        while (true) {
            System.out.println("===Employee Management System===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Name");
                    String name = sc.nextLine();
                    System.out.println("Enter Email");
                    String email = sc.nextLine();
                    System.out.println("Enter Department");
                    String dept = sc.nextLine();
                    System.out.println("Enter Salary");
                    double sal = sc.nextDouble();

                    Employee emp = new Employee();
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
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    String newName = sc.nextLine();

                    Employee e = new Employee();
                    e.setId(id);
                    e.setName(newName);

                    dao.updateEmployee(e);
                    break;
                    
                case 4:
                    System.out.println("Enter id to delete");
                    int id1 = sc.nextInt();
                    Employee e1 = new Employee();
                    e1.setId(id1);
                    dao.deleteEmployee(e1);
                    break;
                    
                case 5:
                    System.out.println("5. Exit...");
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
```

---

## 📚 Project Components

### 1. **DBUtil Package**
   - **DBConnection.java**: Manages PostgreSQL database connections using JDBC
   - Loads PostgreSQL driver dynamically
   - Returns connection objects for database operations

### 2. **Model Package**
   - **Employee.java**: POJO (Plain Old Java Object) representing an employee
   - Contains employee attributes: id, name, email, department, salary
   - Provides getters and setters for all properties

### 3. **DAO Package**
   - **EmployeeDao.java**: Data Access Object implementing CRUD operations
   - Handles SQL queries and database transactions
   - Manages PreparedStatements for secure query execution

### 4. **Main Package**
   - **MainApp.java**: Entry point of the application
   - Provides interactive menu-driven user interface
   - Handles user input and application flow

---

## 🔄 How It Works

### Database Flow

```
User Input (MainApp.java)
        ↓
Switch Case Logic
        ↓
EmployeeDao Methods (CRUD Operations)
        ↓
SQL Queries (INSERT, SELECT, UPDATE, DELETE)
        ↓
DBConnection.getConnection() (PostgreSQL Connection)
        ↓
Execute Query & Display Results
        ↓
Back to Menu
```

### JDBC Operation Steps

1. **Load Driver**: `Class.forName("org.postgresql.Driver")`
2. **Establish Connection**: `DriverManager.getConnection(url, user, password)`
3. **Create Statement**: `con.prepareStatement(sql)`
4. **Execute Query**: `executeUpdate()` or `executeQuery()`
5. **Process Results**: Loop through ResultSet
6. **Close Resources**: Connection, Statement, ResultSet

---


## 🤝 Contributing

Contributions are welcome! If you have suggestions for improvements or bug fixes:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add YourFeature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a Pull Request

---

## 📄 License

This project is open-source and available under the **MIT License**. See the LICENSE file for details.

---

## 👤 Author

**Rajitha Peddagangannagari**
- GitHub: [@rajithapeddagangannagari7337](https://github.com/rajithapeddagangannagari7337)
- Project Repository: [EmployeeManagement_Jdbc](https://github.com/rajithapeddagangannagari7337/EmployeeManagement_Jdbc)

---

