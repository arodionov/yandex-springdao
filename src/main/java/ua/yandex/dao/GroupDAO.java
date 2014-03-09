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
public interface GroupDAO {
    Group find(Integer id);
    List<Group> findAll();
    boolean create(Group group);
    boolean addStudentToGroup(Group group, Student student);
    //boolean update(Group group);
}
