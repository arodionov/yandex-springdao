/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.model;

/**
 *
 * @author Amdrii
 */
public class Student {
    Integer studentID;
    String studentName;
    Integer studentYear;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(Integer studentYear) {
        this.studentYear = studentYear;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" + "sudentID=" + studentID + ", studenName=" + studentName + ", studentYear=" + studentYear + '}'+"\n";
    }    
}
