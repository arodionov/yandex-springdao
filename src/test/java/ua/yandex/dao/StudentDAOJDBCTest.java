package ua.yandex.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.yandex.model.Student;

public class StudentDAOJDBCTest extends DAOTestsTemplate{
    
    @Autowired
    private StudentDAO studentDAO;
    
    
    @Before
    public void clearDB(){
        jdbcTemplate.execute("TRUNCATE TABLE Student");
    }    
   
    @Test
    public void testCreateStudentNoExceptions() {
        Student stud = new Student("ABC", 1);                
        studentDAO.create(stud);
    }
    
    @Test
    public void testCreateStudent() {
        Student stud = new Student("ABC", 1);                
        studentDAO.create(stud);
        
        int size = jdbcTemplate.queryForObject("select count(*) from Student", Integer.class);
        Assert.assertEquals(1, size);
    }
    
    
    @Test   
    public void testFindByNameStudent() {
        Student stud = new Student("ABC", 1); 
        studentDAO.create(stud);
        
        Student actualResult = studentDAO.findByName("ABC");
        Assert.assertEquals(stud, actualResult);
    }
    
    @Test       
    public void testFindAllStudents() {  
        Student stud1 = new Student("ABC", 1); 
        Student stud2 = new Student("BC", 2);
        studentDAO.create(stud1);
        studentDAO.create(stud2);
        
        List<Student> actualResult = studentDAO.findAll();
        Assert.assertEquals(2, actualResult.size());
    }    
}