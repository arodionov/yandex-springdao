package ua.yandex;

import java.util.List;
import ua.yandex.dao.ConnectionFactory;
import ua.yandex.dao.DriverManagerDAOJDBCFactory;
import ua.yandex.dao.StudentDAO;
import ua.yandex.dao.StudentDAOJDBC;
import ua.yandex.model.Student;

/**
 * Hello world!
 *
 */
public class App {

//    private static final Properties prop = new Properties();
//
//    static{
//        try {
//            //File file = new File("dao.properties");
//            //System.out.println(file.getCanonicalPath());
//            
//            prop.load(new FileReader("dao.properties"));            
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String driver = "com.mysql.jdbc.Driver"; // prop.getProperty("javabase.jdbc.driver");
        String url = "jdbc:mysql://localhost:3306/socnet"; // prop.getProperty("javabase.jdbc.url");
        String user = "root"; //prop.getProperty("javabase.jdbc.username");
        String pass = "root"; // prop.getProperty("javabase.jdbc.password");

        ConnectionFactory daoFactory = 
                new DriverManagerDAOJDBCFactory(driver, url, user, pass);
        
        StudentDAO studentDAO = new StudentDAOJDBC(daoFactory);
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
