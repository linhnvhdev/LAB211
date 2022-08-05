/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

/**
 *
 * @author Linhnvhdev
 */
public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    public void display(){
        System.out.printf("%-20s%-20s%-15.1f%s\n", countryCode,countryName,totalArea,countryTerrain);
    }
    
}
