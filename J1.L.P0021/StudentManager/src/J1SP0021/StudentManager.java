/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0021;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Linhnvhdev
 */
public class StudentManager {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void createStudent(ArrayList<Student> studentList) {
        // loop until list >= 10 and user dont want to add anymore
        while(true){
            
            System.out.println("Please enter new student information: ");
            String newStudentID, newStudentName;
            // loop until user enter a valid ID and name
            while(true){
                newStudentID = Input.inputString("Please enter student ID: ");
                newStudentName = Input.inputString("Please enter student name: ");
                // if ID and name type in is valid
                if(isValidIdAndName(studentList, newStudentID, newStudentName)){
                    break;
                }
                else{
                    System.out.println("A student with that ID already exist with different name, please try again");                     
                }
            }
            // loop until user input non duplicate semester and course
            String newStudentSemester;
            String newStudentCourse;
            while(true){
                newStudentSemester = Input.inputSemester();
                newStudentCourse = Input.inputCourse();
                // if student already exist in the list
                if(checkSemesterCourseExist(studentList, newStudentID, newStudentSemester, newStudentCourse)) 
                    System.out.println("This semester and course for this student already exits, please try again");
                else break;
            }
            Student newStudent = new Student(newStudentID, newStudentName, newStudentSemester, newStudentCourse);
            studentList.add(newStudent);
            System.out.println("Create a student successful.");
            // if the list has at least 10 student then ask user to continue or not (Y/N)
            if(studentList.size() >= 10){
                System.out.println("Do you want to continue(Y/N)?");
                String option = Input.inputOptionYN();
                // if user input N
                if(option.equalsIgnoreCase("N"))
                    break;
            }
        }
        System.out.println("Student list after create: ");
        display(studentList);
    }

    public static void findAndSort(ArrayList<Student> studentList) {
        // if student list empty
        if(studentList.isEmpty()){
            System.out.println("Student list empty, can't find and sort");
            return;
        }
        
        String inputStudentName = Input.inputString("Enter the student name you want to find: ");
        ArrayList<Student> listStudentFindByName = getListStudentFindByName(studentList,inputStudentName);
        if(listStudentFindByName.isEmpty()){ // cant find any student with that name
            System.out.println("No student found with that name");
            return;
        }
        
        Collections.sort(listStudentFindByName);
        
        System.out.println("Student found, sort by name: ");
        display(listStudentFindByName);
    }

    public static void updateStudent(ArrayList<Student> studentList, Student stu) {
        String newStudentID;
        String newStudentName;
        String newStudentSemester;
        String newStudentCourse; 
        // loop until user enter the valid information for update
        System.out.println("Please enter update information: ");
        newStudentID = Input.inputString("Please enter student ID: ");
        newStudentName = Input.inputString("Please enter student name: ");
        newStudentSemester = Input.inputSemester();
        newStudentCourse = Input.inputCourse();
        // if update information already exist in the list
        if(checkSemesterCourseExist(studentList, newStudentID, newStudentSemester, newStudentCourse)){
            System.out.printf("Student ID %s are already added with semester %s and course %s ",newStudentID, newStudentSemester, newStudentCourse);
            System.out.println("Update fail.");
            return;
        }
        stu.setId(newStudentID);
        updateName(studentList,stu.getId(),newStudentName);
        stu.setSemester(newStudentSemester);
        stu.setCourse(newStudentCourse);
        System.out.println("Update successful");
        System.out.println("Student list after update: ");
        display(studentList);
    }

    public static void updateOrDelete(ArrayList<Student> studentList) {
        // if student List is empty
        if(studentList.isEmpty()){
            System.out.println("Student list empty, can't update or update");
            return;
        }        
        String findID;
        ArrayList<Student> listStudentFindByID;
        //loop until user input a ID exist in the list
        while(true){
            findID = Input.inputString("Please enter the ID of the student you want to update/delete: ");
            //Find a student by ID:
            listStudentFindByID = getListStudentByID(studentList,findID);
            // if can't find any student with that ID
            if(listStudentFindByID.isEmpty()){
                System.out.println("No Student with that ID, please enter again");
            }
            else break;
        }
        
        Student foundStudent = chooseStudentInList(listStudentFindByID);
        
        // Choose option Update/Delete
        
        System.out.println("Do you want to update (U) or delete (D) student? ");
        String option = Input.inputOptionUD();
        // if user input U update else delete
        if(option.equalsIgnoreCase("U")) 
            updateStudent(studentList, foundStudent);
        else if(option.equalsIgnoreCase("D"))
            deleteStudent(studentList, foundStudent);
    }

    public static void deleteStudent(ArrayList<Student> studentList,Student stu) {
        studentList.remove(stu);
        System.out.println("Delete successful");
        System.out.println("Student list after delete: ");
        display(studentList);
    }

    public static ArrayList<Student> getListStudentFindByName(ArrayList<Student> studentList,String inputStudentName) {
        ArrayList<Student> listStudentFound = new ArrayList<Student>();
        // traverse through list of student
        for(Student curStudent : studentList){
            // check if current student in the list contains name of the student search
            // to add to list
            if(curStudent.getName().contains(inputStudentName))
                listStudentFound.add(curStudent);
        }
        return listStudentFound;
    }

    public static void display(ArrayList<Student> studentList) {
        // if list is empty
        if(studentList.isEmpty()){
            System.out.println("Student list is empty");
            return;
        }
        // traverse and print every student info
        for(Student stu:studentList){
            System.out.printf("%-5s|%-15s|%-10s|%s\n",stu.getId(),stu.getName(), stu.getSemester(), stu.getCourse());
        }
    }

    public static ArrayList<Student> getListStudentByID(ArrayList<Student> studentList,String findID) {
        ArrayList<Student> listStudentByID = new ArrayList<Student>();
        // traverse the student list find student with same id
        for(Student curStudent : studentList){
            // if student have same id need to find, add to the list
            if(curStudent.getId().equals(findID))
                listStudentByID.add(curStudent);
        }
        return listStudentByID;
    }

    public static void report(ArrayList<Student> studentList) {
        // if student list is empty
        if(studentList.isEmpty()){
            System.out.println("No student to make report");
            return;
        }
        ArrayList<Report> studentReport = new ArrayList<Report>();
        // traverse through list of student to make report about every student
        for(Student curStudent : studentList){
            // if we havent made any report about this student
            if(!isReportExist(studentReport,curStudent.getId(),curStudent.getCourse())){
                Report newReport = new Report(curStudent.getId(),curStudent.getName(),curStudent.getCourse());
                // find and count all student with same course add to total course
                for(Student curStudent2 : studentList){
                    // check if this is the same student with same course to count to report
                    if(curStudent.getId().equals(curStudent2.getId())
                        && curStudent.getCourse().equals(curStudent2.getCourse()))
                        newReport.totalCourse++;
                }
                // Add new Report to the student report
                studentReport.add(newReport);
            }
        }
        printReport(studentReport);
    }

    private static Student chooseStudentInList(ArrayList<Student> studentList) {
        System.out.println("Please choose a student in this student list: ");
        display(studentList);
        int option = Input.inputIntRange("Choose an option from 1 to " + studentList.size() + ": ",1, studentList.size());
        return studentList.get(option-1);
    }
    
    private static boolean checkSemesterCourseExist(ArrayList<Student> studentList, String id, String semester, String course){
        // check every student if id,semester,course is exist in the list
        for(Student curStudent : studentList){
            // if the same student has the same info about course and semester return true
            if(curStudent.getId().equals(id) &&
                curStudent.getSemester().equals(semester) && 
                curStudent.getCourse().equals(course))
                return true;
        }
        return false;
    }

    private static boolean isReportExist(ArrayList<Report> studentReport, String ID, String course) {
        // check every report to find a report about same student and course
        for(Report curReport : studentReport){
            // if id course is equal then report exist return true
            if(curReport.ID.equals(ID) && curReport.course.equals(course))
                return true;
        }
        return false;
    }

    private static void printReport(ArrayList<Report> studentReport) {
        // if the report is empty
        if(studentReport.isEmpty()){
            System.out.println("No report of student");
            return;
        }
        System.out.println("Student report: ");
        // print every report of student
        for(Report curReport : studentReport){
            System.out.printf("%-15s|%-5s|%d\n", curReport.name, curReport.course, curReport.totalCourse);
        }
    }

    static boolean isValidIdAndName(ArrayList<Student> studentList,String newStudentID, String newStudentName) {
        // traverse to check compare student in the list with new ID and name 
        for(Student curStudent : studentList){
            // if there's already a student with that id but different name then false
            if(curStudent.getId().equals(newStudentID) && !curStudent.getName().equals(newStudentName)){
                return false;
            }
        }
        return true;
    }

    static void updateName(ArrayList<Student> studentList, String id, String newStudentName) {
        // traverse the student list to find person with same id
        for(Student stu: studentList){
            // if they have the same id then update the name
            if(stu.getId().equals(id))
                stu.setName(newStudentName);
        }
    }
}
