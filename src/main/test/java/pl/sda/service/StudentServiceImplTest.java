package pl.sda.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.model.Gender;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-mvc-config.xml"})
public class StudentServiceImplTest {

    @Qualifier("service")
    @Resource
    StudentService studentService;

    StudentService studentServiceTest;

    @Before
    public void setUp(){
        studentServiceTest = studentService;
    }

    @Test
    public void getStudentByLogin() throws Exception {
        assertEquals("Anna", studentServiceTest.getStudentByLogin("GrazynaGrazyna").getFirstName());
        assertEquals(12, studentServiceTest.getStudentByLogin("pupa").getIndexNumber());
    }

    @Test
    public void addStudent() throws Exception {
        assertTrue(studentServiceTest.addStudent(new Student("MarianFlarian", "Marian", "Flarian", 16, Gender.M, Specialisation.MED)));
        assertEquals(5, studentServiceTest.getAllStudents().size());
        assertEquals("Marian", studentServiceTest.getStudentByLogin("MarianFlarian").getFirstName());
    }

    @Test
    public void removeStudent() throws Exception {
        assertTrue(studentServiceTest.removeStudent("HalinaMalina"));
        assertEquals(3, studentServiceTest.getAllStudents().size());
    }
}