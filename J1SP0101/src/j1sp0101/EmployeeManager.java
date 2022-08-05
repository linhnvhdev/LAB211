/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0101;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Linhnvhdev
 */
public class EmployeeManager {

    static void addEmployees(ArrayList<Employee> EmployeeList){
        boolean keepAdding = false;
        // loop until user stop adding employees
        do{
            System.out.println("Please enter employee ID:");
            String newID = Input.inputNonDupID(EmployeeList);
            
            System.out.println("Please enter employee first name:");
            String newFirstName = Input.inputFirstName();
            
            System.out.println("Please enter employee last name:");
            String newLastName = Input.inputLastName();
            
            System.out.println("Please enter employee phone number:");
            String newPhoneNumber = Input.inputPhoneNumber();
            
            System.out.println("Please enter employee email:");
            String newEmail = Input.inputEmail();
            
            System.out.println("Please enter employee address:");
            String newAddress = Input.inputAddress();
            
            System.out.println("Please enter employee DOB(dd/MM/yyyy):");
            String newDOB = Input.inputDOB();
            
            System.out.println("Please choose employee Sex:");
            String newSex = Input.inputSex();
            
            System.out.println("Please enter employee salary:");
            int newSalary = Input.inputSalary();
            
            System.out.println("Please enter employee Agency:");
            String newAgency = Input.inputAgency();
            // Add new employee to the list
            EmployeeList.add(new Employee(newID, newFirstName, newLastName, newPhoneNumber, newEmail, newAddress, newDOB, newSex, newSalary, newAgency));
            // Ask user to continue or not
            System.out.println("Do you want to add another employee(Y/N): ");
            String option = Input.inputYN();
            if(option.equalsIgnoreCase("Y")) keepAdding = true;
            else keepAdding = false;
        } while(keepAdding);
        System.out.println("Employee list after add: ");
        displayList(EmployeeList);
    }

    static void update(ArrayList<Employee> EmployeeList) {
        // if list is empty no update can be made
        if(EmployeeList.isEmpty()){
            System.out.println("Emloyee list is empty, can't perform update option");
            return;
        }
        
        Employee foundEmployee = findEmployeeByID(EmployeeList);
        System.out.println("Employee found:\n " + foundEmployee);
        
        System.out.println("Please enter update employee ID:");
        String newID = Input.inputUpdateID(EmployeeList,foundEmployee.ID);
        
        System.out.println("Please enter update employee first name:");
        String newFirstName = Input.inputFirstName();
        
        System.out.println("Please enter update employee last name:");
        String newLastName = Input.inputLastName();
        
        System.out.println("Please enter update employee phone number:");
        String newPhoneNumber = Input.inputPhoneNumber();
        
        System.out.println("Please enter update employee email:");
        String newEmail = Input.inputEmail();
        
        System.out.println("Please enter update employee address:");
        String newAddress = Input.inputAddress();
        
        System.out.println("Please enter update employee DOB:");
        String newDOB = Input.inputDOB();
        
        System.out.println("Please choose update employee Sex:");
        String newSex = Input.inputSex();
        
        System.out.println("Please enter update employee salary:");
        int newSalary = Input.inputSalary();
        
        System.out.println("Please enter update employee Agency:");
        String newAgency = Input.inputAgency();
        
        Employee updateEmployee = new Employee(newID, newFirstName, newLastName, newPhoneNumber, newEmail, newAddress, newDOB, newSex, newSalary, newAgency);
        foundEmployee.setEmployee(updateEmployee);
        
        System.out.println("Employee list after update: ");
        displayList(EmployeeList);
    }

    static void remove(ArrayList<Employee> EmployeeList) {
        // if employee list is empty, can't perform remove function
        if(EmployeeList.isEmpty()){
            System.out.println("Employee list is empty, can't perform remove option");
            return;
        }
        
        Employee foundEmployee = findEmployeeByID(EmployeeList);
        System.out.println("Found employee:\n" + foundEmployee);
        EmployeeList.remove(foundEmployee);
        System.out.println("Employee list after remove: ");
        displayList(EmployeeList);
    }

    static void search(ArrayList<Employee> EmployeeList) {
        // if employee list is empty, can't perform search function
        if(EmployeeList.isEmpty()){
            System.out.println("Employee list is empty, can't perform search option");
            return;
        }        
        System.out.println("Please enter name or part of employee name to find: ");
        String findNameString = Input.inputString();
        ArrayList<Employee> EmployeesFound = findEmployeeByName(EmployeeList,findNameString);
        // can't find any employee contain the input as part of name
        if(EmployeesFound.isEmpty()){
            System.out.println("No employee found");
            return;
        }
        System.out.println("Employee found: ");
        displayList(EmployeesFound);
    }

    static void sortBySalary(ArrayList<Employee> EmployeeList) {
        // if employee list is empty, can't perform remove function
        if(EmployeeList.isEmpty()){
            System.out.println("Employee list is empty, can't perform sort option");
            return;
        }        
        System.out.println("Employee list before sort: ");
        displayList(EmployeeList);
        // sort by salary
        Collections.sort(EmployeeList);
        System.out.println("Employee list afer sort salary: ");
        displayList(EmployeeList);
        
    }

    private static Employee findEmployeeByID(ArrayList<Employee> EmployeeList) {
        String ID;
        System.out.println("Please enter employee ID to find:");
        // loop until user input an exist ID
        while(true){
            ID = Input.inputString();
            if(Checker.isIDExist(EmployeeList,ID)){
                break;
            }
            else{
                System.err.println("Employee with that ID don't exist, please enter again");
            }
        }
        // search the list to return employee with the ID 
        for(Employee e : EmployeeList){
            if(e.ID.equalsIgnoreCase(ID))
                return e;
        }
        return null;
    }
    
    static void displayList(ArrayList<Employee> EmployeeList){
        //Display information of every Employee
        for(Employee e : EmployeeList){
            System.out.println(e);
        }
    }

    static ArrayList<Employee> findEmployeeByName(ArrayList<Employee> EmployeeList, String findNameString) {
        ArrayList<Employee> EmployeesFound = new ArrayList<>();
        // check every employee first and last name contain the string or not
        for(Employee e : EmployeeList){
            // if the string is part of the name, add to the found list
            if(e.firstName.contains(findNameString) || e.lastName.contains(findNameString))
                EmployeesFound.add(e);
        }
        return EmployeesFound;
    }
    
}
