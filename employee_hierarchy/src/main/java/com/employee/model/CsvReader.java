package com.employee.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class CsvReader {

    public Map<String,Employee> readEmployees(String filePath) throws IOException{
        Map<String,Employee> employeeMap=new HashMap<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String [] data=line.split(",");
                String managerId = data.length > 4 ? data[4] : "";
                Employee emp = new Employee(data[0], data[1], data[2], Double.parseDouble(data[3]), managerId);
                employeeMap.put(data[0], emp);

            }
        }
        for(Employee e:employeeMap.values()){
            if(e.getManagerId()!=null && !e.getManagerId().isEmpty()){
                Employee manager=employeeMap.get(e.getManagerId());
                if(manager!=null){
                    manager.addSubordinate(e);
                }
            }
        }
        return employeeMap;
    } 
}

