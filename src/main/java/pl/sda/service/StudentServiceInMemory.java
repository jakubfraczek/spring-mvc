package pl.sda.service;

import pl.sda.dao.StudentDAO;
import pl.sda.model.Student;

import java.util.List;


public class StudentServiceInMemory implements StudentService {

    private StudentDAO studentDAO;

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

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }
}
