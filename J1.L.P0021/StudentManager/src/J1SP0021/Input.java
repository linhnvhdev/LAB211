/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0021;

import java.util.Scanner;



/**
 *
 * @author Linhnvhdev
 */
public class Input {
    
    static Scanner sc = new Scanner(System.in);
    
    static Student inputNewStudent(){
        String newStudentID = inputString("Please enter student ID: ");
        String newStudentName = inputString("Please enter student name: ");
        String newStudentSemester = inputSemester();
        String newStudentCourse = inputCourse();
        return new Student(newStudentID, newStudentName, newStudentSemester, newStudentCourse);
    }

    public static String inputString(String message) {
        // loop until user input a non empty string
        while(true){
            System.out.print(message);
            String input = sc.nextLine().trim();
            // if input is empty
            if(!input.isEmpty()) return input;
            else System.err.println("You can't left the field empty, please type again");
        }
    }

    public static String inputCourse() {
        System.out.println("Please choose a student course: ");
        System.out.println("1. Java");
        System.out.println("2. .NET");
        System.out.println("3. C/C++");
        int option = inputIntRange("Please choose an option: ", 1,3);
        switch(option){
            case 1: 
                return "Java";
            case 2:
                return ".NET";
            case 3:
                return "C/C++";
        }
        return null;
    }
    
    public static int inputIntRange(String message, int min,int max){
        // loop until user input a number in range        
        while(true){
            try{
                String userInput = inputString(message);
                int input = Integer.parseInt(userInput);
                // check if input is in range
                if(input >= min && input <= max){
                    return input;
                }
                else{
                    System.err.println("Number not in range, please type again");
                }
            }
            catch(NumberFormatException e){
                System.err.println("Please type a number, please type again");
            }
        }
    }
    
    public static String inputOptionYN(){
        // loop until user input Y or N        
        while(true){
            String option = inputString("");
            if(option.equalsIgnoreCase("N") || option.equalsIgnoreCase("Y")) return option;
            else{
                System.out.println("Option unavailable, please choose Y for Yes or N for No: ");
            }
        }
    }

    static String inputOptionUD() {
        // loop until user input U or D 
        while(true){
            String option = inputString("");
            if(option.equalsIgnoreCase("U") || option.equalsIgnoreCase("D")) return option;
            else{
                System.out.println("Option unavailable, please choose U for Update or D for Delete: ");
            }
        }        
    }

    static String inputSemester() {
        System.out.println("Please choose a semester: ");
        System.out.println("1. Spring");
        System.out.println("2. Summer");
        System.out.println("3. Fall");
        System.out.println("4. Winter");
        int option = inputIntRange("Please choose an option: ", 1,4);
        switch(option){
            case 1: 
                return "Spring";
            case 2:
                return "Summer";
            case 3:
                return "Fall";
            case 4:
                return "Winter";
        }
        return null;        
    }
}
