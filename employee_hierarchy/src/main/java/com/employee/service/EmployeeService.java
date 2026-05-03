package com.employee.service;
import java.util.Map;

import com.employee.model.Employee;
public class EmployeeService {

    public void analyze(Map<String,Employee> employees){
        for(Employee emp:employees.values()){
            checkSalary(emp);
            checkReportingLine(emp,employees);
        }

    }
    public double calculateShortFall(Employee manager){
        if(manager.getSubordinates().isEmpty()){
            return 0;
        }
        double avg=manager.getSubordinates().stream().mapToDouble(Employee::getSalary).average().orElse(0);
        double min=avg*1.2;
        return manager.getSalary()<min? min- manager.getSalary():0;
    }
      public double calculateExcess(Employee manager){
        if(manager.getSubordinates().isEmpty()){
            return 0;
        }
        double avg=manager.getSubordinates().stream().mapToDouble(Employee::getSalary).average().orElse(0);
        double max=avg*1.5;
        return manager.getSalary()>max?manager.getSalary()-max:0;
    }

    private void checkSalary(Employee manager){
        double shortFall=calculateShortFall(manager);
        double excess=calculateExcess(manager);
        if(shortFall>0){
            System.out.println(manager.getFirstName()+" Earns Less By "+ shortFall);
        }
        if(excess>0){
            System.out.println(manager.getFirstName()+" Earns More By "+ excess);

        }
    }
    public int reportingLineTooLong(Employee employee,Map<String,Employee> employees){
        int count=0;
        String managerId=employee.getManagerId();
        while(managerId!=null && !managerId.isEmpty()){
            // count++;
            Employee manager=employees.get(managerId);
            // managerId=manager!=null?manager.getManagerId():null;
            if (manager == null || manager.getManagerId().isEmpty()) {
            break;
            }

            count++;
            managerId = manager.getManagerId();

        }
        return count>4?count-4:0;
    }

    private void checkReportingLine(Employee employee, Map<String,Employee> employees){
        int extra=reportingLineTooLong(employee,employees);
        if(extra>0){
            System.out.println(employee.getFirstName()+" Reporting Line Too Long By "+extra);
        }
    }
}
