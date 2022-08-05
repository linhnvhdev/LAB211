/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0070;

import java.util.Locale;

/**
 *
 * @author Linhnvhdev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Locale vietnamese = new Locale("vi");
    static Locale english = new Locale("en");
    
    public static void main(String[] args) {
        // Step 1: Display menu:
        displayMenu();
        // Step 2: user select an option 1 to 3
        int option = Input.inputOption("Please choice one option: ",1,3);
        switch(option){
            // if option = 1: login in Vietnamese
            case 1:
                Ebank.login(vietnamese);
                break;
            // if option = 2: login in English
            case 2:
                Ebank.login(english);
                break;
            // if option = 3: break;
            case 3:
                return;
        }
    }

    private static void displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

}
