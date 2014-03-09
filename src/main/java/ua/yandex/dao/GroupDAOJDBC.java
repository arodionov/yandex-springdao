/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.yandex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static ua.yandex.dao.DAOJDBCUtil.close;
import ua.yandex.model.Group;
import ua.yandex.model.Student;

/**
 *
 * @author andrii
 */
public class GroupDAOJDBC implements GroupDAO{
    private ConnectionFactory cnnFactory;

    public Group find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addStudentToGroup(Group group, Student student) {
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Student "
                    + "(name, year) VALUES (?, ?)");
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getStudentYear());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }
    
}
