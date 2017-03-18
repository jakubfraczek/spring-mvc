package pl.sda.dao;

import pl.sda.model.Student;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStudentDAO implements StudentDAO {

    private List<Student> students;


    @Override
    public Student getStudentByLogin(String login) {
        return students.stream().filter(s -> s.getLogin().equals(login)).findAny().get();
    }

    @Override
    public boolean addStudent(Student student) {
        if (students.stream().filter(s -> s.getLogin().equals(student.getLogin())).findFirst().orElse(null) == null && students.stream().filter(s -> s.getIndexNumber() == (student.getIndexNumber())).findFirst().orElse(null) == null) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeStudent(String login) {
        int before = students.size();
        students = students.stream().filter(s -> !s.getLogin().equals(login)).collect(Collectors.toList());
        if (before > students.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateStudent(Student student) {
        students = students.stream().map(s -> s.getLogin().equals(student.getLogin()) ? student : s).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return students.stream().filter(s -> s.getFirstName().equals(name)).collect(Collectors.toList());
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }
}
