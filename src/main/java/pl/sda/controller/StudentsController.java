package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;
import pl.sda.service.StudentService;

import javax.validation.Valid;

@RequestMapping("/student")
@Controller
public class StudentsController {

    @Autowired
    @Qualifier("serviceStudentSQL")
    private StudentService studentService;


    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView studentForm() {
        ModelAndView model = new ModelAndView();
        model.addObject("student", new Student());
        model.addObject("specENUM", Specialisation.values());

        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("addStudent");
        } else {
            studentService.addStudent(student);
            return model;
        }

    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public ModelAndView viewStudents() {
        ModelAndView model = new ModelAndView("studentsList");
        model.addObject("students", studentService.getAllStudents());
        return model;
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ModelAndView studentDetails(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("viewStudents");
        model.addObject("s", studentService.getStudentByLogin(login));
        return model;
    }


    @RequestMapping(value = "/remove/{login}", method = RequestMethod.GET)
    public ModelAndView removeStudent(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");
        studentService.removeStudent(login);
        return model;
    }

    @RequestMapping(value = "/update/{login}", method = RequestMethod.GET)
    public ModelAndView studentToUpdate(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("updateStudent");
        model.addObject("student", studentService.getStudentByLogin(login));
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("updateStudent");
        } else {
            studentService.updateStudent(student);
            return model;
        }
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ModelAndView findByNameForm() {
        ModelAndView model = new ModelAndView("findByName");
        return model;
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public ModelAndView findByName(String name) {
        ModelAndView model = new ModelAndView("studentsList");

        model.addObject("students", studentService.findStudentsByName(name));
        return model;
    }
}
