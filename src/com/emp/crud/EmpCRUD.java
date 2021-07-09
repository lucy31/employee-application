package com.emp.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmpCRUD {

	public static void main(String args[]) throws IOException {
		
		int choice = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmpOperations empOps = new EmpOperations();
		
		do {
			System.out.println("--------------\n");
			System.out.println("Enter Choice\n"
					+ "1. Create \n"
					+ "2. Display \n"
					+ "3. Raise Salary \n"
					+ "4. Delete \n"
					+ "5. Exit\n");
			System.out.println("--------------");
			choice = Integer.parseInt(br.readLine());	

			switch(choice){
				case 1: empOps.addEmployee();
						break;
						
				case 2: empOps.displayEmployees();
						break;
						
				case 3: empOps.raiseSalary();
						break;
						
				case 4: empOps.deleteEmployee();
						break;
						
				case 5: break;
				
				default: System.out.println("Please Enter a Correct Choice");
			}
			
		}while(choice != 5);
	}
}
