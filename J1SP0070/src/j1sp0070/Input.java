/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0070;

import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class Input {
    
    static Scanner sc = new Scanner(System.in);

    static int inputOption(String message, int min, int max) {
        // loop until user input a number in range        
        while(true){
            try{
                String userInput = inputString(message);
                int option = Integer.parseInt(userInput);
                // check if input is in range
                if(option >= min && option <= max){
                    return option;
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
    
    static String inputString(String message){
        // loop until user input a non-empty string
        while(true){
            System.out.print(message);
            String userInput = sc.nextLine().trim();
            // if userInput is empty print error else return userInput
            if(userInput.isEmpty()){
                System.err.println("empty input, please try again");
            }
            else return userInput;
        }
    }

    static String inputAccountNumber(String message, String errorMessage) {
        // lopp until user input a valid account number
        while(true){
            String accountNumber = inputString(message);
            // check if account number is valid return it else print error
            if(Ebank.checkAccountNumber(accountNumber)) return accountNumber;
            else{
                System.out.println(errorMessage);
            }
        }
    }

    static String inputPassword(String message, String errorMessage) {
        // lopp until user input a valid account number
        while(true){
            String password = inputString(message);
            // check if account number is valid return it else print error
            if(Ebank.checkPassword(password)) return password;
            else{
                System.out.println(errorMessage);
            }
        }        
    }
    
}
