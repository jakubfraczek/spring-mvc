package pl.sda.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.model.Gender;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-mvc-config.xml"})
public class InMemoryStudentDAOTest {

    @Resource
    StudentDAO studentsDao;

    StudentDAOInMemory studentsDaoTest = new StudentDAOInMemory();

    @Before
    public void setUp() {
        studentsDaoTest.setStudents(studentsDao.getAllStudents());
    }

    @Test
    public void getStudentByLogin() throws Exception {
        assertEquals("Anna", studentsDaoTest.getStudentByLogin("GrazynaGrazyna").getFirstName());
        assertEquals(12, studentsDaoTest.getStudentByLogin("pupa").getIndexNumber());
    }

    @Test
    public void addStudent() throws Exception {
        assertTrue(studentsDaoTest.addStudent(new Student("MarianFlarian", "Marian", "Flarian", 16, Gender.M, Specialisation.MED)));
        assertEquals(5, studentsDaoTest.getAllStudents().size());
        assertEquals("Marian", studentsDaoTest.getStudentByLogin("MarianFlarian").getFirstName());
    }

//    @Test
//    public void removeStudent() throws Exception {
//        assertTrue(studentsDaoTest.removeStudent("HalinaMalina"));
//        assertEquals(3, studentsDaoTest.getAllStudents().size());
//    }

    @Test
    public void updateStudent() throws Exception {
        studentsDaoTest.updateStudent(new Student("HalinaMalina", "Anna", "Nowak", 14, Gender.F, Specialisation.IT));

        assertEquals("HalinaMalina", studentsDaoTest.getAllStudents().get(2).getLogin());
        assertEquals(Specialisation.IT, studentsDaoTest.getStudentByLogin("HalinaMalina").getSpecialisation());
    }

    @Test
    public void getAllStudents() throws Exception {
        Assert.assertNotNull(studentsDaoTest.getAllStudents());
    }

    @Test
    public void findStudentsByName() throws Exception {
        assertNotNull(studentsDaoTest.findStudentsByName("Anna"));
        assertEquals(2, studentsDaoTest.findStudentsByName("Anna").size());
    }

}