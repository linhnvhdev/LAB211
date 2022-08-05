/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1sp0011;

/**
 *
 * @author Linhnvhdev
 */
public class Checker {
    
    public static boolean isBinary(String inputNumber){
        if(inputNumber.isEmpty()) return false;
        // check if every charater is 0 or 1
        for(int i = 0;i < inputNumber.length();i++){
            char curDigit = inputNumber.charAt(i);
            if(Number.numberDigit.indexOf(curDigit) == -1 || // can't find in digit pattern
               Number.numberDigit.indexOf(curDigit) > 1)     // not 0 or 1
                return false;
        }
        return true;
    }
        
    public static boolean isDecimal(String inputNumber){
        if(inputNumber.isEmpty()) return false;
        // check if every charater is 0 to 9
        for(int i = 0;i < inputNumber.length();i++){
            char curDigit = inputNumber.charAt(i);
            if(Number.numberDigit.indexOf(curDigit) == -1 || // can't find in digit pattern
               Number.numberDigit.indexOf(curDigit) > 9)     // not 0 to 9
                return false;
        }
        return true;
    }
    
    public static boolean isHexaDecimal(String inputNumber){
        if(inputNumber.isEmpty()) return false;
        // check if every charater is 0 to 9 or A to F
        for(int i = 0;i < inputNumber.length();i++){
            char curDigit = inputNumber.charAt(i);
            if(Number.numberDigit.indexOf(curDigit) == -1) // can't find in digit pattern 0 to 9 or A to F
                return false;
        }
        return true;
    }
    
    public static boolean checkInputNumber(String inputNumber,int base){
        if(base == 2) return isBinary(inputNumber);
        if(base == 16) return isHexaDecimal(inputNumber);
        return isDecimal(inputNumber);
    }
}
