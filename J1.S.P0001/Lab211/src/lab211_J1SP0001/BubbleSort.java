/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_J1SP0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Step 1: ask user to input a positive number 
        
        int number = inputPositiveNumber();
        
        //Step 2: Generated random integer in number range for 
        // each array element
        
        int[] arr = generateRandomArray(number);
        // create array for testing
        //int[] arr = createTestArray();
        
        //Step 3: Display array before sort
        
        displayArrayBeforeSort(arr);
       
        //Step 4: Sort array
        
        bubbleSort(arr);
        
        //Step 5: display after sort
        
        displayArrayAfterSort(arr);
    }

    private static int inputPositiveNumber() {
        // loop until user enter a positive integer number
        while(true){
            try{
                System.out.println("Enter number of array: ");
                String userInput = sc.nextLine().trim();
                // check if user input is empty
                if(userInput.isEmpty())
                    System.out.println("You can't leave this field empty, please type again");
                else{
                    int number = Integer.parseInt(userInput);
                    // check if the number is a negative or positive
                    if(number <= 0){ 
                        System.out.println("You have to input a positive number, please type again");
                    }
                    else return number;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Not a number, please type again:");
            }
        }
    }
    
    private static int[] createTestArray(){
        int[] arr = {5, 1, 12, -5, 16};
        //int[] arr = {1, 3, 5, 4, 6, 8};
        //int[] arr = {1, 2, 2, 4, 5, 6};
        //int[] arr = {6, 8, 2, 8, 6, 6, 8};
        return arr;
    }

    private static int[] generateRandomArray(int number) {
        Random rd = new Random();
        int arr[] = new int[number];
        // created random number in range of number for each element
        for(int i = 0;i < number;i++)
            arr[i] = rd.nextInt(number);
        return arr;
    }
    
    
    private static void displayArrayBeforeSort(int[] arr) {
        System.out.print("Unsorted array: ");
        displayArray(arr);
        System.out.println("");
    }

    private static void displayArrayAfterSort(int[] arr) {
        System.out.print("Sorted array: ");
        displayArray(arr);
    }
    

    private static void displayArray(int[] a) {
        // Empty array
        if(a.length == 0) return;
        System.out.print("[" + a[0]);
        // print every element of array
        for(int i = 1;i < a.length;i++)
            System.out.print(", " + a[i]);
        System.out.print("]");
    }
    
    private static void testSortArray(int[] arr,int cur){
        displayArray(arr);
        if(arr[cur] > arr[cur+1])
            System.out.println("   " + arr[cur] + " > " + arr[cur+1] + ", swap");
        else System.out.println("   " + arr[cur] + " <= " + arr[cur+1] + ", ok");
    }

    private static void bubbleSort(int[] arr) {
        boolean swapDone;
        int numLoop = 0;
        // loop until no swap has been done.
        do{
            swapDone = false;
            // traverse array to compare every pair of adjacent  
            // elements from the beginning up to the last element
            // may not yet sorted
            for(int i = 0; i < arr.length-1-numLoop;i++){
                //testSortArray(arr, i);
                // If they are in reverse order, swap them
                if(arr[i] > arr[i+1]){
                    int middle = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = middle;
                    swapDone = true;
                }
            }
            numLoop++;
        }while(swapDone);
    }
}
