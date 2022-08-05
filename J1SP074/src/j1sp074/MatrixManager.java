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
public class MatrixManager {

    static void displayMatrix(int[][] resultMatrix) {
        int row = resultMatrix.length;
        int column = resultMatrix[0].length;
        // get row position
        for(int i = 0;i < row;i++){
            // get column position
            for(int j = 0;j < column;j++){
                System.out.print("[" + resultMatrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        // if one of 2 matrix don't exist then can't perform operation
        if(matrix1 == null || matrix2 == null) return null;
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        // if 2 matrix dont have the same size
        if(row1 != row2 || column1 != column2){
            System.out.println("2 matrix has different size, can't perform addition");
            return null;
        }
        else{
            int[][] resultMatrix = new int[row1][column1];
            // get row position of resultMatrix = row1 = row 2
            for(int i = 0;i < row1;i++){
                // get column position resultMatrix = column1 = column2
                for(int j = 0; j < column1;j++){
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return resultMatrix;
        }
    }   

    static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        // if one of 2 matrix don't exist then can't perform operation
        if(matrix1 == null || matrix2 == null) return null;
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        // if 2 matrix dont have the same size
        if(row1 != row2 || column1 != column2){
            System.out.println("2 matrix has different size, can't perform subtraction");
            return null;
        }
        else{
            int[][] resultMatrix = new int[row1][column1];
            // get row position of resultMatrix = row1 = row 2
            for(int i = 0;i < row1;i++){
                // get column position resultMatrix = column1 = column2
                for(int j = 0; j < column1;j++){
                    resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return resultMatrix;
        } 
    }

    static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        // if one of 2 matrix don't exist then can't perform operation
        if(matrix1 == null || matrix2 == null) return null;
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        // if 2 matrix dont have the same size
        if(row2 != column1){
            System.out.println("Row size of Matrix2 and Column size of Matrix1 is difference, can't perform multiplication ");
            return null;
        }
        else{
            int[][] resultMatrix = new int[row1][column2];
            // get row position of resultMatrix
            for(int i = 0;i < row1;i++){
                // get column position of resultMatrix 
                for(int j = 0; j < column2;j++){
                    resultMatrix[i][j] = 0;
                    // perform dot product with row i matrix 1 and column j matrix 2
                    for(int k = 0;k < column1; k++){
                        resultMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
            return resultMatrix;
        }
    }
    
}