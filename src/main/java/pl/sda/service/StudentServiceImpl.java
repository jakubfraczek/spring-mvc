package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.InMemoryStudentDAO;
import pl.sda.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private InMemoryStudentDAO studentDAO;

    @Override
    public Student getStudentByLogin(String login) {
        return studentDAO.getStudentByLogin(login);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public boolean removeStudent(String login) {
        return studentDAO.removeStudent(login);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDAO.findStudentsByName(name);
    }
}
