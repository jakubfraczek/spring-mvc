package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;
import pl.sda.service.StudentService;

@Controller
public class StudentFormController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView studentForm() {
        ModelAndView model = new ModelAndView();
        model.addObject("student", new Student());


        model.addObject("specENUM", Specialisation.values());

        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");


        studentService.addStudent(student);

        return model;
    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public ModelAndView viewStudents(){
        ModelAndView model = new ModelAndView("studentsList");
        model.addObject("students", studentService.getAllStudents());
        return model;
    }

    @RequestMapping(value = "/student/{login}", method = RequestMethod.GET)
    public ModelAndView studentDetails(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("viewStudents");
        model.addObject("s", studentService.getStudentByLogin(login));
        return model;
    }

    @RequestMapping(value = "/student/{login}/er", method = RequestMethod.GET)
    public ModelAndView studentDetails(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("viewStudents");
        model.addObject("s", studentService.getStudentByLogin(login));
        return model;
    }
}
