/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1sp0011;

import java.math.BigInteger;

/**
 *
 * @author Linhnvhdev
 */
public class Number {

    String value;
    int base;

    public static final String numberDigit = "0123456789ABCDEF";

    public Number(String value, int base) {
        this.value = value;
        this.base = base;
    }

    public static BigInteger toBaseDecimal(Number number) {
        BigInteger valueInDec = BigInteger.ZERO;
        // calculate value in decimal for the first i+1 digit
        for (int i = 0; i < number.value.length(); i++) {
            String curDigit = String.valueOf(number.value.charAt(i));
            // decimal value of i digit = 
            // decimal value of i-1 digit * base + digit value decimal
            valueInDec = valueInDec.multiply(BigInteger.valueOf(number.base));
            valueInDec = valueInDec.add(BigInteger.valueOf(numberDigit.indexOf(curDigit)));
            System.out.println("value in decimal of first " + i+1 +" digit is " + valueInDec);
        }
        return valueInDec;
    }

    public static Number decimalToOtherBase(BigInteger value, int base) {
        String convertValue = "";
        // divide value with base until 0 
        while (value != BigInteger.ZERO) {
            // next digit to the left in convert value = value % base
            BigInteger r = value.mod(BigInteger.valueOf(base));
            convertValue = numberDigit.charAt(r.intValue()) + convertValue;
            System.out.print(value + " % " + base + " = ");
            value = value.divide(BigInteger.valueOf(base));
            System.out.println(value + " mod " + r);
        }
        return new Number(convertValue, base);
    }

    @Override
    public String toString() {
        return value + "(" + base + ")";
    }
}
