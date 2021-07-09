package com.emp.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.emp.crud.dao.EmpDAO;
import com.emp.crud.model.Employee;

public class EmpOperations {

	EmpDAO empDao;
	
	public EmpOperations(){
		empDao = new EmpDAO();
	}
	
	public void addEmployee() {
		Employee emp = new Employee();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter Name : ");
			emp.setEname(br.readLine());
			System.out.println("Enter Age : ");
			emp.setAge(Integer.parseInt(br.readLine()));;
			System.out.println("Enter Salary : ");
			emp.setSalary(Double.parseDouble(br.readLine()));
			System.out.println("Enter Designation : ");
			emp.setDesignation(br.readLine());
		}
		catch(IOException e){
			System.out.println("Failed to add enployee");
			e.printStackTrace();
		}
		boolean result = empDao.addEmp(emp);
		
		if(result)
			System.out.println("Employee successfully added");
		else
			System.out.println("Failed to add enployee");
	}
	
	public void displayEmployees() {
		List<Employee> empList = empDao.viewEmployees();
		if(empList.size()==0)
			System.out.println("No employee records found");
		else
			empList.stream().forEach(System.out::println);
	}

	public void raiseSalary() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter Percentage : ");
			double raise = Double.parseDouble(br.readLine());
			boolean result = empDao.incSalary(raise);
			if(result)
				System.out.println("All employee records successfully updated");
			else
				System.out.println("Not able to update all records");
		}
		catch(IOException e){
			System.out.println("Failed to raise salary");
			e.printStackTrace();
		}
	}

	public void deleteEmployee() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter EId: ");
			int eId = Integer.parseInt(br.readLine());
			boolean result = empDao.deleteEmp(eId);
			if(result)
				System.out.println("Employee with EId "+eId+" deleted");
			else
				System.out.println("Employee record not deleted");
		}
		catch(IOException e){
			System.out.println("Failed to delete enployee");
			e.printStackTrace();
		}
	}
}
