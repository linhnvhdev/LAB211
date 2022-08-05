/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1SP0021;

/**
 *
 * @author Linhnvhdev
 */
public class Report {
    String ID;
    String name;
    String course;
    int totalCourse;

    public Report(String ID, String name, String course) {
        this.ID = ID;
        this.name = name;
        this.course = course;
        this.totalCourse = 0;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
}
