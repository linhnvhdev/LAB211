/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0101;

/**
 *
 * @author Linhnvhdev
 */
public class Employee implements Comparable<Employee>{

    String ID;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    String DOB; // Date of birth
    String sex;
    int salary;
    String agency;

    public Employee(String ID, String firstName, String lastName, String phoneNumber, String email, String address, String DOB, String sex, int salary, String agency) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }
    
    public void setEmployee(Employee updateEmployee){
        this.ID = updateEmployee.ID;
        this.firstName = updateEmployee.firstName;
        this.lastName = updateEmployee.lastName;
        this.phoneNumber = updateEmployee.phoneNumber;
        this.email = updateEmployee.email;
        this.address = updateEmployee.address;
        this.DOB = updateEmployee.DOB;
        this.sex = updateEmployee.sex;
        this.salary = updateEmployee.salary;
        this.agency = updateEmployee.agency;        
    }

    public boolean equals(Employee otherEmployee){
        return (ID.equals(otherEmployee.ID) && 
                firstName.equals(otherEmployee.firstName) && 
                lastName.equals(otherEmployee.lastName) && 
                phoneNumber.equals(otherEmployee.phoneNumber) && 
                email.equals(otherEmployee.email) && 
                address.equals(otherEmployee.address) && 
                DOB.equals(otherEmployee.DOB) &&
                sex.equals(otherEmployee.sex) && 
                salary == otherEmployee.salary && 
                agency.equals(otherEmployee.agency));
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-20s|%-10s|%-15s|%-20s|%-15s|%-15s|%s|%-10d|%-15s|",
                            ID,firstName,lastName,phoneNumber,email,
                            address,DOB,sex,salary,agency);
    }

    @Override
    public int compareTo(Employee t) {
        return salary - t.salary;
    }
    
}
