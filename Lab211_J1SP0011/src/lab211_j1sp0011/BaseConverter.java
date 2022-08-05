/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1sp0011;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class BaseConverter {

    /**
     * @param args the command line arguments
     */
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // loop until user close the program;
        while(true){
            // create menu interface
            menu();
            int option = Input.inputIntRange(1, 2);
            if(option == 1){ // start converting
                // User choose the base number input
                int inputBase = inputBaseNumberInput();
                // User choose the base number output
                int outputBase = inputBaseNumberOutput();
                // User enter the input value
                Number inputValue = Input.inputNumber(inputBase);
                // Convert input value to value in output base
                Number ouputValue = convert(inputValue, outputBase);
                // print output value
                print(ouputValue);
            }
            else  // close program
                return;
        }
    }

    private static int inputBaseNumberInput() {
        System.out.println("Please choose base number input: ");        
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        return Input.inputBaseNumber();
    }
    
    private static int inputBaseNumberOutput() {
        System.out.println("Please choose base number output: ");        
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        return Input.inputBaseNumber();
    }

    private static void print(Number number) {
        System.out.println("The Number after converted is: ");
        System.out.println(number.toString());
    }
    
    private static Number convert(Number number,int baseNumberOutput){
        // change from input base to decimal
        BigInteger valueInDec = Number.toBaseDecimal(number);
        // change from decimal to output base
        return Number.decimalToOtherBase(valueInDec, baseNumberOutput);
    }

    private static void menu() {
        System.out.println("======== Base Conversion Program ========");
        System.out.println("1. Start converting");
        System.out.println("2. Exit program");
        System.out.println("Please enter your option: ");
    }
    
}
