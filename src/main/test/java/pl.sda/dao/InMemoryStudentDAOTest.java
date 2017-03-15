package pl.sda.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.Gender;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentDAOTest {

    InMemoryStudentDAO studentsDAQ = new InMemoryStudentDAO();
    List<Student> studentsList;

    @Before
    public void setUp() {
        studentsList = new ArrayList<>();
        studentsList.add(new Student("pupa", "Jan", "Nowak", 12, Gender.M, Specialisation.IT));
        studentsList.add(new Student("GrazynaGrazyna", "Anna", "Iksinska", 13, Gender.F, Specialisation.LAW));
        studentsList.add(new Student("HalinaMalina", "Anna", "Nowak", 14, Gender.F, Specialisation.MED));
        studentsList.add(new Student("JanuszekKrol", "Janusz", "Kowalski", 15, Gender.M, Specialisation.MGMT));
    }

    @Test
    public void getStudentByLogin() throws Exception {
        Assert.assertEquals(studentsList.get(1), studentsDAQ.getStudentByLogin("GrazynaGrazyna"));
        Assert.assertEquals(studentsList.get(0), studentsDAQ.getStudentByLogin("pupa"));
    }

    @Test
    public void addStudent() throws Exception {

    }

    @Test
    public void removeStudent() throws Exception {

    }

    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void getAllStudents() throws Exception {
        Assert.assertNotNull(studentsDAQ.getAllStudents());
    }

    @Test
    public void findStudentsByName() throws Exception {

    }

}