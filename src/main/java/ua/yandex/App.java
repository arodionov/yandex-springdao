package ua.yandex;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
      
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        
        StudentDAO studentDAO = appCtx.getBean("studentDAO", StudentDAO.class);
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
