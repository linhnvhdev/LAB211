/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0021;

import java.util.Comparator;

/**
 *
 * @author Linhnvhdev
 */
public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private String semester;
    private String course; // There are only three courses: Java, .Net, C/C++

    public Student(){
        
    }
    
    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public void setStudent(Student student){
        this.setCourse(student.course);
        this.setId(student.id);
        this.setName(student.name);
        this.setSemester(student.semester);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + '}';
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }
    
    public boolean equals(Student other){
        return (id.equals(other.id) && 
                name.equals(other.name) && 
                semester.equals(other.semester) && 
                course.equals(other.course));
    }
}
