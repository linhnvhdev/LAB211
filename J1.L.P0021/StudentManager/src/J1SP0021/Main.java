/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0021;

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
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList = createTestStudentList();
        StudentManager.display(studentList);
        // loop until option = 5 exit program
        while(true){
            // Step 1: create menu 
            displayMenu();
            // Step 2: user select an option 
            int option = Input.inputIntRange("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ", 1, 5);
            switch(option){
                // Step 3: if option = 1: Create student
                case 1:
                    StudentManager.createStudent(studentList);
                    break;
                // Step 4: if option = 2: Find and Sort student
                case 2:
                    StudentManager.findAndSort(studentList);
                    break;
                // Step 5: if option = 3: update/delete student
                case 3:
                    StudentManager.updateOrDelete(studentList);
                    break;
                // Step 6: if option = 4: report
                case 4:
                    StudentManager.report(studentList);
                    break;
                // Step 7: if option = 5: exit
                case 5:
                    return;
            }
        }
    }
    
    private static void displayMenu(){
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t" + "1.  Create" );
        System.out.println("\t" + "2.  Find and Sort" );
        System.out.println("\t" + "3.  Update/Delete" );
        System.out.println("\t" + "4.  Report" );
        System.out.println("\t" + "5.  Exit" );
    }

    private static ArrayList<Student> createTestStudentList() {
        ArrayList<Student> std = new ArrayList<Student>();
        std.add(new Student("A123","Ngo Viet A","Spring", "Java"));
        std.add(new Student("A123","Ngo Viet A","Fall", ".NET"));
        std.add(new Student("A125","Nguyen Viet A","Spring", "C/C++"));
        std.add(new Student("A126","Bui Hong Duc","Summer", "Java"));
        std.add(new Student("A126","Bui Hong Duc","Fall", "Java"));
        std.add(new Student("A126","Bui Hong Duc","Spring", "Java"));
        std.add(new Student("A126","Bui Hong Duc","Fall", ".NET"));
        std.add(new Student("A128","Nguyen B","Summer", "Java"));
        //std.add(new Student("A129","Ngo Viet A","Summer", "Java"));
        return std;
    }
    
}
/*
A123 Ngo Viet A          Spring    java
A124 Ngo Viet A          Fall      .Net
A125 Nguyen Viet A       Spring    C/C++
A126 Bui Hong Duc        Summer    java
A127 Vu Minh Sang        Fall      java
A128 Nguyen B            Summer    Java
A129 Bui Hong Duc        Fall      .Net
B000 Vu B                Spring    JAVA
B169 Ngo Viet A          Summer    Java
C169 Nguyen C            Fall      C/C++
*/

// create phải là check course and semester chứ ko phải chung chung như student information
// update cả ID