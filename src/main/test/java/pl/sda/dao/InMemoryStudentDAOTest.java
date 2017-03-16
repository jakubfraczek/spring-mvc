package pl.sda.dao;

import org.junit.Before;
import org.junit.Test;
import pl.sda.model.Gender;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InMemoryStudentDAOTest {

    InMemoryStudentDAO studentsDAO = new InMemoryStudentDAO();
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
        assertEquals(studentsList.get(1), studentsDAO.getStudentByLogin("GrazynaGrazyna"));
        assertEquals(studentsList.get(0), studentsDAO.getStudentByLogin("pupa"));
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
       assertNotNull(studentsDAO.getAllStudents());
    }

    @Test
    public void findStudentsByName() throws Exception {

    }

}