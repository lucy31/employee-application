package com.emp.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emp.crud.model.Employee;

public class EmpDAO {
	
	public boolean addEmp(Employee emp){
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "hbstudent", "hbstudent");
				Statement stmt = conn.createStatement())
		{
			String empInsert = "insert into employee_crud.employee "
					+ "(ename, age, salary, designation) values "
					+ "('"+emp.getEname()+"', "+emp.getAge()+", "+emp.getSalary()+", '"+emp.getDesignation()+"')";
			
			int cntInsert = stmt.executeUpdate(empInsert);
			if(cntInsert==0)
				return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Employee> viewEmployees(){
		List<Employee> empList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "hbstudent", "hbstudent");
				Statement stmt = conn.createStatement())
		{
			String empInsert = "select * from employee_crud.employee ";
			ResultSet rs = stmt.executeQuery(empInsert);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEid(Integer.parseInt(rs.getString("eid")));
				emp.setEname(rs.getString("ename"));
				emp.setAge(Integer.parseInt(rs.getString("age")));
				emp.setSalary(Double.parseDouble(rs.getString("salary")));
				emp.setDesignation(rs.getString("designation"));
				empList.add(emp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public boolean incSalary(double raise) {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "hbstudent", "hbstudent");
				Statement stmt = conn.createStatement())
		{	String query = "set sql_safe_updates=0";
			stmt.executeQuery(query);
			query = "update employee_crud.employee set salary = salary + (salary * "+raise+"/100.0)";
			int cntUpdate = stmt.executeUpdate(query);
			query = "set sql_safe_updates=1";
			stmt.executeQuery(query);
			if(cntUpdate==0)
				return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteEmp(int eid) {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "hbstudent", "hbstudent");
				Statement stmt = conn.createStatement())
		{	String query = "delete from employee_crud.employee where eid = "+eid;
			int cntDelete = stmt.executeUpdate(query);
			if(cntDelete==0)
				return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
