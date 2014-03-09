/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.dao;

import java.util.List;
import ua.yandex.model.Group;
import ua.yandex.model.Student;

/**
 *
 * @author Amdrii
 */
public interface StudentDAO {
    Student find(Integer id);
    List<Student> findAll();
    boolean create(Student student);
    Student getByName(String studentName);
    //boolean upadate(Student student);
    //List<Student> findAllInGroup(Integer groupID);
    //List<Student> findAllInGroup(Group group);
    
}
