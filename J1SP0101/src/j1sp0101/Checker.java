/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0101;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Linhnvhdev
 */
public class Checker {
    static boolean isIDExist(ArrayList<Employee> EmployeeList,String ID) {
        // check every employee if it has the same ID as the ID need check
        for(Employee e : EmployeeList)
            if(e.ID.equalsIgnoreCase(ID)) return true;
        return false;
    }

    static boolean isValidEmail(String email) {
        // valid email pattern: (Group1)@(Group2).(Group3)
        // group 1: gmail name include letter, number or printable character !#$%&'*+-/=?^_`{|}~
        // group 2 and 3 make the the domain name include letter
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9_!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z]+\\.[A-Za-z]+");
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
        // invalid email:
        // Abcd
        // abc@example
        // Abc.example.com
        // A@b@c@example.com
        // A@example_2.d
    }

    static boolean isValidDate(String DOB) {
        DateFormat validDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        validDateFormat.setLenient(false);
        try{
            validDateFormat.parse(DOB);
            return true;
        }
        catch(ParseException e){
            return false;
        }
        // invalid date:
        // 31/09/2009
        // 29/02/2005
        // 32/05/2000
        // 00/04/1998
    }

    static boolean isValidDOB(String DOB) {
        try{
            Date curDate = new Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            // change cur date to the same format as dob
            curDate = df.parse(df.format(curDate));
            Date dateOfBirth = df.parse(DOB);
            return dateOfBirth.before(curDate);
        }
        catch(ParseException e){
            System.err.println("invalid date format");
            return false;
        }
    }
}
