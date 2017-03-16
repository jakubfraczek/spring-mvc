package pl.sda.service;

import pl.sda.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentByLogin(String login);

    boolean addStudent(Student student);

    boolean removeStudent(String login);

    void updateStudent(Student student);

    List<Student> getAllStudents();

    List<Student> findStudentsByName(String name);
}
