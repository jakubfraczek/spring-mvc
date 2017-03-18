package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.StudentDAO;
import pl.sda.model.Student;
import pl.sda.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service("serviceStudentSQL")
public class StudentServiceSQL implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByLogin(String login) {
        return studentRepository.findByLogin(login);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentRepository.save(student) != null;
    }

    @Override
    public boolean removeStudent(String login) {
        studentRepository.delete(studentRepository.findByLogin(login));
        return studentRepository.findByLogin(login) == null;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students == null ? new ArrayList<Student>() : students;
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByFirstName(name);
    }

}
