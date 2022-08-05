/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0070;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author Linhnvhdev
 */
public class Ebank {
    
    //static ResourceBundle languageBundle;
    static final char[] captchaChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
            'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w','x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U','V', 'W', 'X',
            'Y', 'Z', '0', '1', '2', '3', '4', '5', '6','7', '8', '9'};
    static Hashtable<String,String> accountData = new Hashtable();
    
    static{
        accountData.put("0123456789","123456ab");
        accountData.put("9999999999","1a2b3c4d5e");
    }

    static void login(Locale languageLocale) {
        // loop until user login successfully
        while(true){
            String accountNumber = Input.inputAccountNumber(getDisplayText(languageLocale,"AccountNumber"),
                    getDisplayText(languageLocale,"AccountNumberError"));
            String password = Input.inputPassword(getDisplayText(languageLocale,"Password"),
                    getDisplayText(languageLocale,"PasswordError"));
            // if account number and password match in data: check captcha to log in
            // else login failed
            if(checkAccountExist(accountNumber,password)){
                // loop until user enter captcha correct
                while(true){
                    String captchaGenerated = generateCaptcha();
                    System.out.println(getDisplayText(languageLocale,"Captcha") + captchaGenerated);
                    String captchaInput = Input.inputString(getDisplayText(languageLocale,"InputCaptcha"));
                    String resultCheckCaptcha = checkCaptcha(languageLocale,captchaInput, captchaGenerated);
                    // if captcha result is correct login success 
                    // else print message
                    if(resultCheckCaptcha.equals(getDisplayText(languageLocale,"CaptchaCorrect"))){
                        System.out.println(getDisplayText(languageLocale,"LoginSuccess"));
                        return;
                    }
                    else{
                        System.out.println(resultCheckCaptcha);
                    }
                }
            }
            else{
                System.out.println(getDisplayText(languageLocale,"AccountPasswordIncorrect"));
                System.out.println(getDisplayText(languageLocale,"LoginFailed"));
            }
        }
    }

    //public static void setLocale(ResourceBundle languageBundle,Locale languageLocale) {
   //     languageBundle = ResourceBundle.getBundle("Language/LanguageBundle",languageLocale);
   // }

    public static String getDisplayText(Locale languageLocale, String text) {
        ResourceBundle languageBundle = ResourceBundle.getBundle("Language/LanguageBundle",languageLocale);
        String textDisplayed = languageBundle.getString(text);
        return textDisplayed;
    }

    static boolean checkAccountNumber(String accountNumber) {
        // valid account number must contains 10 digits
        String validAccountNumberPattern = "[0-9]{10}";
        // check if account number match the valid account pattern
        if(accountNumber.matches(validAccountNumberPattern))
            return true;
        else 
            return false;
    }

    static boolean checkPassword(String password) {
        // String contains at least a letter
        String letter = ".*[a-zA-Z].*";
        // String contains at least a digits
        String digits = ".*[0-9].*";
        // valid password contain 8-31 alphanumeric character
        String validPasswordPattern = "[0-9a-zA-Z]{8,31}";
        // check if password match valid pattern and must have both letter and digit
        if(password.matches(validPasswordPattern) 
                && password.matches(digits) && password.matches(letter)) 
                return true;
        else 
            return false;        
    }

    static String generateCaptcha() {
        String captcha = "";
        int captchaLength = 5;
        Random rand = new Random();
        for(int i = 0;i < captchaLength;i++){
            int index = rand.nextInt(captchaChar.length);
            captcha += captchaChar[index];
        }
        return captcha;
    }

    static String checkCaptcha(Locale languageLocale, String input, String captchaGenerated) {
        // check if input match the generated captcha 
        if(captchaGenerated.equals(input)){
            return getDisplayText(languageLocale,"CaptchaCorrect");
        }
        else{
            return getDisplayText(languageLocale,"CaptchaIncorrect");
        }
    }

    private static boolean checkAccountExist(String accountNumber, String password) {
        // check if account number exist then check password else return false
        if(accountData.containsKey(accountNumber)){
            String matchingPassword = accountData.get(accountNumber);
            return password.equals(matchingPassword);
        }
        else return false;
    }
    
}
