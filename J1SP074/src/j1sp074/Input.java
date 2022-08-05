/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp074;

import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class Input {

    static Scanner sc = new Scanner(System.in);
    
    public static int inputOption(int min, int max) {
        // loop until user input a number from min to max
        while(true){
            int option = inputNumber("Your choice:");
            // check if option in range min to max
            if(option >= min && option <= max){
                return option;
            }
            else{
                System.err.println("option has to be from " + min + " to " + max);
            }
        }
    }
    
    public static int inputNumber(String message) {
        // loop until user input a number from min to max
        while(true){
            System.out.print(message);
            String userInput = sc.nextLine().trim();
            // check if user dont input anything
            if(userInput.isEmpty()){
                System.err.println("Empty input, please try again");
            }
            else{
                try{
                    int number = Integer.parseInt(userInput);
                    return number;
                }
                catch(NumberFormatException e){
                    System.err.println("Input has to be a number, please try again");
                }
            }
        }
    }
    
    public static int inputPositiveNumber(String message){
        while(true){
            int number = inputNumber(message);
            // check if the number is negative
            if(number <= 0){
                System.out.println("row and column value must be a positive number");
            }
            else return number;
        }
    }

    public static int[][] inputMatrix(int matrixNumber){
        int row = inputPositiveNumber("Enter Row Matrix " + matrixNumber + ":");
        int column = inputPositiveNumber("Enter Column Matrix " + matrixNumber + ":");
        int[][] matrix = new int[row][column];
        // get row position of matrix
        for(int i = 0;i < row;i++){
            // get column position of matrix
            for(int j = 0;j < column;j++){
                matrix[i][j] = inputMatrixValue(matrixNumber,i,j);
            }
        }
        return matrix;
    }

    public static int inputMatrixValue(int matrixNumber,int row,int column) {
        // loop until user input all the matrix value a number 
        while(true){
            System.out.printf("Enter Matrix%d[%d][%d]:",matrixNumber,row+1,column+1);
            String userInput = sc.nextLine().trim();
            // check if user dont input anything
            if(userInput.isEmpty()){
                System.err.println("Empty input, please try again");
            }
            else{
                try{
                    int number = Integer.parseInt(userInput);
                    return number;
                }
                catch(NumberFormatException e){
                    System.out.println("Value of matrix is digit");
                }
            }
        }
    }

    static int[][] inputSecondMatrix(String operation, int[][] firstMatrix) {
        int firstMatrixRow = firstMatrix.length;
        int firstMatrixColumn = firstMatrix[0].length;
        int row = inputRowSecondMatrix(operation,firstMatrixRow, firstMatrixColumn);
        int column = inputColumnSecondMatrix(operation, firstMatrixColumn);
        int[][] matrix = new int[row][column];
        // get row position of matrix
        for(int i = 0;i < row;i++){
            // get column position of matrix
            for(int j = 0;j < column;j++){
                matrix[i][j] = inputMatrixValue(2,i,j);
            }
        }
        return matrix;
    }
    
    static int inputRowSecondMatrix(String operation,int rowMatrix1,int columnMatrix1){
        while(true){
            int row = inputPositiveNumber("Enter Row Matrix 2:");
            // if operation is addition or subtraction
            if(operation.equals("addition") || operation.equals("subtraction")){
                // check if row of 2 matrix is the same size
                if(row == rowMatrix1){
                    return row;
                }
                else{
                    System.out.println("row of second matrix must be equals to the row of first matrix to perform "+operation+", please try again");
                }
            }
            else{
                // check if row and column of first matrix has same size
                if(row == columnMatrix1){
                    return row;
                }
                else{
                    System.out.println("row of second matrix must be equals to the column of first matrix to perform " + operation);
                }
            }
        }
    }
    
    static int inputColumnSecondMatrix(String operation,int columnMatrix1){
        while(true){
            int column = inputPositiveNumber("Enter Column Matrix 2:");
            // if operation is addition or subtraction
            if(operation.equals("addition") || operation.equals("subtraction")){
                // check if 2 column of 2 matrix has same size
                if(column == columnMatrix1){
                    return column;
                }
                else{
                    System.out.println("column of second matrix must be equals to the column of first matrix to perform "+operation+", please try again");
                }
            }
            else{
                return column;
            }
        }
    }    
}
