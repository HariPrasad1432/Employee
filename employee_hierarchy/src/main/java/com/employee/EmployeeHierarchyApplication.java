package com.employee;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.model.CsvReader;
import com.employee.service.EmployeeService;

@SpringBootApplication
public class EmployeeHierarchyApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(EmployeeHierarchyApplication.class, args);
	    CsvReader reader = new CsvReader();
        EmployeeService service = new EmployeeService();
        var employees = reader.readEmployees("src\\main\\java\\com\\employee.csv");
        service.analyze(employees);
	}

}
