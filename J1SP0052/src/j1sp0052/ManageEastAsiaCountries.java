/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Linhnvhdev
 */
public class ManageEastAsiaCountries {

    static void addCountryInformation(ArrayList<EastAsiaCountries> countryList) {
        // if list of country already have full 11 country
        if(countryList.size() == 3){
            System.out.println("All 11 countries have been added, can't add more");
            return;
        }
        // keep input until country list size is 11 
        while(countryList.size() < 3){
            String code = Input.inputCode("Enter code of country:\n",countryList);
            String name = Input.inputString("Enter name of country:\n");
            float totalArea = Input.inputPositiveFloat("Enter total Area:\n");
            String terrain = Input.inputString("Enter terrain of country:\n");
            EastAsiaCountries newCountry = new EastAsiaCountries(code, name, totalArea, terrain);
            countryList.add(newCountry);
        }
        System.out.println("All 11 countries have been added successfully");
    }

    static void displayCountriesInfo(ArrayList<EastAsiaCountries> countryList) {
        // if country list is empty print message and return
        if(countryList.isEmpty()){
            System.out.println("No country information");
            return;
        }
        System.out.printf("%-20s%-20s%-15s%s\n","ID","Name","Total Area","Terrain");
        // traverse to print info of every country
        for(EastAsiaCountries curCountry: countryList){
            curCountry.display();
            System.out.println("");
        }        
    }

    static void searchInfoByName(ArrayList<EastAsiaCountries> countryList) {
        String nameFind = Input.inputString("Enter the name you want to search for:\n");
        ArrayList<EastAsiaCountries> countryListFound = getListSearchByName(countryList,nameFind);
        // if can't find any one then print message and turn else display list
        if(countryListFound.isEmpty()){
            System.out.println("No country found");
            return;
        }
        else{
            displayCountriesInfo(countryListFound);
        }
    }

    static void displaySortedByName(ArrayList<EastAsiaCountries> countryList) {
        // sort by name ascending
        Collections.sort(countryList, new Comparator<EastAsiaCountries>(){
            @Override
            public int compare(EastAsiaCountries t, EastAsiaCountries t1) {
                return t.countryName.compareTo(t1.countryName);
            }
        });
        displayCountriesInfo(countryList);
    }

    static boolean checkCodeExist(ArrayList<EastAsiaCountries> countryList, String code) {
        // traverse to check the code for every country in the list
        for(EastAsiaCountries curCountry: countryList){
            // if code is the same as one in the list return true
            if(curCountry.countryCode.equals(code))
                return true;
        }
        return false;
    }

    static ArrayList<EastAsiaCountries> getListSearchByName(ArrayList<EastAsiaCountries> countryList, String nameFind) {
        ArrayList<EastAsiaCountries> countryFoundList = new ArrayList();
        // traverse to check the name for every country in the list
        for(EastAsiaCountries curCountry: countryList){
            // if this country contains the name find in the list add to list
            if(curCountry.countryName.contains(nameFind))
                countryFoundList.add(curCountry);
        }
        return countryFoundList;
    }
    
}
