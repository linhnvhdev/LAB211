/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class Input {
    
    static Scanner sc = new Scanner(System.in);
    
    public static String inputString(String message) {
        // loop until user input a non empty string
        while(true){
            System.out.print(message);
            String input = sc.nextLine().trim();
            // if input is empty
            if(!input.isEmpty()) return input;
            else System.out.println("You can't left the field empty, please type again");
        }
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
                    System.out.println("Number not in range, please type again");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please type a number, please type again");
            }
        }
    }

    static String inputCode(String message, ArrayList<EastAsiaCountries> countryList) {
        // loop until user input a non-dup code
        while(true){
            String code = inputString(message);
            if(ManageEastAsiaCountries.checkCodeExist(countryList,code)){
                System.out.println("Duplicate code, please try again");
            }
            else return code;
        }
    }

    static float inputPositiveFloat(String message) {
        // loop until user input a positive float number        
        while(true){
            try{
                String userInput = inputString(message);
                Float input = Float.parseFloat(userInput);
                // check if input is positive return it else print error
                if(input > 0){
                    return input;
                }
                else{
                    System.out.println("Number have to be positive, please type again");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please type a float type number");
            }
        }        
    }
}
