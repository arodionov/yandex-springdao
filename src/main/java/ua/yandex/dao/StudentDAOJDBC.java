/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.yandex.model.Student;

import static ua.yandex.dao.DAOJDBCUtil.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amdrii
 */
public class StudentDAOJDBC implements StudentDAO {

    private ConnectionFactory cnnFactory;

    public StudentDAOJDBC(ConnectionFactory cnnFactory) {
        this.cnnFactory = cnnFactory;
    }

    @Override
    public Student find(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from Student where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = (map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<Student>();

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from Student");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return students;
    }

    @Override
    public boolean create(Student student) {
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

    private Student map(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setStudentID(resultSet.getInt(1));
        student.setStudentName(resultSet.getString(2));
        student.setStudentYear(resultSet.getInt(3));
        return student;
    }

    @Override
    public Student getByName(String studentName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.
                    prepareStatement("select * from Student where studentname = ?");
            preparedStatement.setString(1, studentName);
            //resultSet = preparedStatement.executeQuery();
            statement = connection.createStatement();
            String sql = "select * from Student where studentname = '" + studentName + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            
            if(resultSet.next()) {
                student = map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return student;
    }
}
