package ua.yandex;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.student.StudentRepository;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
      
        ApplicationContext appCtx = 
                new ClassPathXmlApplicationContext("persistenceContext.xml");
        
        StudentRepository repository = appCtx.getBean("studentRepository", StudentRepository.class);
        List<Student> students = repository.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        
        Student stud = repository.findByName("Andrii");
        System.out.println(stud);

    }
}
