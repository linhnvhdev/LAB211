/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0101;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Linhnvhdev
 */
public class Input {

    static Scanner sc = new Scanner(System.in);

    static int inputOption(int min, int max) {
        System.out.println("Please choose your option from " + min + " to " + max + ":");
        while (true) {
            String userInput = inputString();
            try {
                int option = Integer.parseInt(userInput);
                if (option < min || option > max) {
                    System.err.println("option out of range, please enter again");
                } 
                else{
                    return option;
                }
            } catch (NumberFormatException e) {
                System.err.println("Input has to be a number, please enter again");
            }
        }
    }

    static String inputNonDupID(ArrayList<Employee> EmployeeList) {
        // loop until user input a non duplicate string
        while(true){
            String ID = inputString();
            if(Checker.isIDExist(EmployeeList,ID)){
                System.err.println("ID already exist, can't be duplicate, please enter again");
            }
            else return ID;
        }
    }

    static String inputFirstName() {
        String firstName = inputString();
        return firstName;
    }

    static String inputLastName() {
        String lastName = inputString();
        return lastName;
    }

    static String inputPhoneNumber() {
        // loop until user input a string of number represent phone number
        while(true){
            String phoneNumber = inputString();
            // check if all character from phone number is 10 or 11 number
            // from 0 to 9
            if(phoneNumber.matches("[0-9]{10,11}")) return phoneNumber;
            else{
                System.err.println("wrong phone number format, please enter again");
            }
        }
    }

    static String inputAddress() {
        String address = inputString();
        return address;
    }

    static String inputDOB(){
        while(true){
            String DOB = inputString();
            if(Checker.isValidDate(DOB)){
                // check if DOB is a day from the past, not future
                if(Checker.isValidDOB(DOB))
                    return DOB;
                else{
                    System.err.println("DOB can't be from the future or present, please try again");
                }
            }
            else{
                System.err.println("Wrong date format or date don't exist, please enter again");
            }
        }
    }

    static String inputEmail() {
        while(true){
            String email = inputString();
            
            if(Checker.isValidEmail(email)) return email;
            else{
                System.err.println("wrong email format, please enter again");
            }
        }
    }

    static String inputSex() {
        System.out.println("1. Male");
        System.out.println("2. Female");
        int option = inputOption(1, 2);
        if(option == 1) return "M";
        else return "F";
    }

    static int inputSalary() {
        int salary = inputIntNumber();
        return salary;
    }

    static String inputAgency() {
        String agency = inputString();
        return agency;
    }

    static String inputYN() {
        while(true){
            String choice = inputString();
            if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) return choice;
            else{
                System.err.println("option unavailable, please choose Y for yes or N for no");
            }
        }
    }

    static String inputString() {
        while (true) {
            String userInput = sc.nextLine().trim();
            if (userInput.isEmpty()) {
                System.err.println("Empty input, please enter again");
            } 
            else {
                return userInput;
            }
        }
    }

    static int inputIntNumber() {
        while (true) {
            String userInput = inputString();
            try {
                int number = Integer.parseInt(userInput);
                if(number > 0)
                    return number;
                else{
                    System.err.println("input can't be negative, please enter again");
                }
            } catch (NumberFormatException e) {
                System.err.println("Input has to be a number, please enter again");
            }
        }
    }
    
    
    static String inputUpdateID(ArrayList<Employee> EmployeeList, String specialID) {
        // loop until user input an ID don't exist in the list
        // or is the same as the special ID
        while(true){
            String ID = inputString();
            if(!ID.equalsIgnoreCase(specialID) && Checker.isIDExist(EmployeeList,ID)){
                System.err.println("update ID can't be the same as other people ID, please enter again");
            }
            else return ID;
        }
    }

}
