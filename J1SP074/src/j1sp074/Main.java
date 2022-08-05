/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp074;

/**
 *
 * @author Linhnvhdev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // loop until user exit program
        while(true){
            // Step 1: Display menu
            displayMenu();
            // Step 2: ask user to select an option 1 - 4
            int option = Input.inputOption(1,4);
            switch(option){
                // Step 3: option = 1: Addition matrix
                case 1:
                    additionMatrix();
                    break;
                // Step 4: option = 2: Subtraction matrix
                case 2:
                    subtractionMatrix();
                    break;
                // Step 5: option = 3: Multiplication matrix
                case 3:
                    multiplicationMatrix();
                    break;
                // Step 6: option = 4: exit
                case 4:
                    return;
            }
        }
    }
    
    private static void additionMatrix(){
        //init
        int[][] matrix1;
        int[][] matrix2;
        int[][] resultMatrix;
        System.out.println("-------- Addition --------");
        matrix1 = Input.inputMatrix(1);
        matrix2 = Input.inputSecondMatrix("addition", matrix1);
        resultMatrix = MatrixManager.additionMatrix(matrix1, matrix2);
        displayEquation('+', matrix1, matrix2, resultMatrix);        
    }
    
    private static void subtractionMatrix(){
        //init
        int[][] matrix1;
        int[][] matrix2;
        int[][] resultMatrix;
        System.out.println("----- Subtraction ------");
        matrix1 = Input.inputMatrix(1);
        matrix2 = Input.inputSecondMatrix("subtraction", matrix1);
        resultMatrix = MatrixManager.subtractionMatrix(matrix1, matrix2);
        displayEquation('-', matrix1, matrix2, resultMatrix);        
    }
    
    private static void multiplicationMatrix(){
        //init
        int[][] matrix1;
        int[][] matrix2;
        int[][] resultMatrix;
        System.out.println("-------- Multiplication -------");
        matrix1 = Input.inputMatrix(1);
        matrix2 = Input.inputSecondMatrix("multiplication",matrix1);
        resultMatrix = MatrixManager.multiplicationMatrix(matrix1, matrix2);
        displayEquation('*', matrix1, matrix2, resultMatrix);        
    }    

    private static void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    private static void displayEquation(char operationSymbol, int[][] matrix1, int[][] matrix2, int[][] resultMatrix) {
        // if can't perform the option
        if(resultMatrix == null) return;
        else{
            System.out.println("-------- Result --------");
            MatrixManager.displayMatrix(matrix1);
            System.out.println(operationSymbol);
            MatrixManager.displayMatrix(matrix2);
            System.out.println("=");
            MatrixManager.displayMatrix(resultMatrix);
        }
    }
    
}