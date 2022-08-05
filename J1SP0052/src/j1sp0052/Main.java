/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.ArrayList;

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
        ArrayList<EastAsiaCountries> countryList = new ArrayList();
        while(true){
            // Step 1: display menu
            displayMenu();
            // Step 2: User input an option
            int option = Input.inputIntRange("Enter your choice: ", 1, 5);
            switch(option){
                // Step 3: if option = 1: Enter the information for 11 countries in Southeast Asia.
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(countryList);
                    break;
                // Step 4: if option = 2: Display already information.
                case 2:    
                    ManageEastAsiaCountries.displayCountriesInfo(countryList);
                    break;
                // Step 5: if option = 3:  Search the country according to the entered country's name.
                case 3:
                    ManageEastAsiaCountries.searchInfoByName(countryList);
                     break;
                // Step 6: if option = 4: Display the information increasing with the country name.
                case 4:
                    ManageEastAsiaCountries.displaySortedByName(countryList);
                    break;
                // Step 7: if option = 5: exit
                case 5:
                    return;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("                              MENU                                       ");
        System.out.println("=========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("=========================================================================");
    }
    
}
