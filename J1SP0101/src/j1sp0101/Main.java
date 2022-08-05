/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0101;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Linhnvhdev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        // create a list of employee for testing
        //ArrayList<Employee> EmployeeList = createTestEmployeeList();
        //EmployeeManager.displayList(EmployeeList);
        // loop until user exit
        while(true){
            // Step 1: Display a menu
            displayMenu();
            // Step 2: user select a option
            int option = Input.inputOption(1,6);
            switch(option){
                // Step 3: option = 1 : Add employees
                case 1: 
                    EmployeeManager.addEmployees(EmployeeList);
                    break;
                // Step 4: option = 2: Update employees
                case 2:
                    EmployeeManager.update(EmployeeList);
                    break;
                // Step 5: option = 3: Remove employees
                case 3: 
                    EmployeeManager.remove(EmployeeList);
                    break;
                // Step 6: option = 4: Search employees
                case 4:
                    EmployeeManager.search(EmployeeList);
                    break;
                // Step 7: option = 5: Sort employees by Salary
                case 5:
                    EmployeeManager.sortBySalary(EmployeeList);
                    break;
                // Step 8: option = 6: exit 
                case 6: 
                    return;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Main menu: ");
        System.out.println("\t1.Add employees");
        System.out.println("\t2.Update employees");
        System.out.println("\t3.Remove employees");
        System.out.println("\t4.Search employees");
        System.out.println("\t5.Sort employees by salary");
        System.out.println("\t6.Exit");
    }

    private static ArrayList<Employee> createTestEmployeeList() {
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        // (Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Agency)
        EmployeeList.add(new Employee("HE103","Ngo Viet Hoang","Linh","0834053123","linh@gmail.com","Ha Noi","08/06/2002","M",1000,"FPT university"));
        EmployeeList.add(new Employee("HE104","Ngo Van","Linh","0834053123","linh@gmail.com","Ha Noi","08/06/2002","M",950,"FPT university"));
        EmployeeList.add(new Employee("HE105","Nguyen Thi","A","0834053123","linh@gmail.com","Ha Noi","08/06/2002","F",300,"FPT university"));
        EmployeeList.add(new Employee("HE106","Ngo Thi","A","0834053123","linh@gmail.com","Ha Noi","08/06/2002","F",450,"FPT university"));
        EmployeeList.add(new Employee("HE107","Ngo Viet","Anh","0834053123","linh@gmail.com","Ha Noi","08/06/2002","M",600,"FPT university"));
        EmployeeList.add(new Employee("HE108","Nguyen Thi","Tinh","0834053123","linh@gmail.com","Ha Noi","08/06/2002","F",975,"FPT university"));
        return EmployeeList;
    }
    
}