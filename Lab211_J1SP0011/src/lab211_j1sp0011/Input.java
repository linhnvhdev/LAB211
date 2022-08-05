/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1sp0011;

import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class Input {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int inputBaseNumber(){
        // user input 1, 2, 3 for base 2, 10, 16
        int baseNumber = 0;
        int option = inputIntRange(1,3);
        switch(option){
            case 1:
                baseNumber = 2;
                break;
            case 2:
                baseNumber = 10;
                break;
            case 3:
                baseNumber = 16;
                break;
        }
        return baseNumber;
    }

    public static Number inputNumber(int baseNumberInput) {      
        String newValue;
        // keep looping until the number format is correct or not empty
        while(true){ 
            System.out.println("Please enter the number to be converted: ");  
            newValue = sc.nextLine().trim();
            if(newValue.isEmpty())
                System.out.println("You can't leave this field empty");
            else if(!Checker.checkInputNumber(newValue, baseNumberInput))
                System.out.println("Wrong number format");
            else break;
        }
        return new Number(newValue,baseNumberInput);
    }    
    
    public static int inputIntRange(int min, int max){
        // keep looping until user input a number in range and not empty
        while(true){
            try{
                String Number = sc.nextLine().trim();
                if(Number.isEmpty()){
                    System.out.println("You can't leave this field empty, please type again:");
                    continue;
                }
                int num = Integer.parseInt(Number);
                if(num >= min && num <= max) return num;
                else System.out.println("Option is not in range, please type again:");
            }
            catch(NumberFormatException e){
                System.out.println("Option has to be a number, please type again: ");
            }
        }
    }
}
