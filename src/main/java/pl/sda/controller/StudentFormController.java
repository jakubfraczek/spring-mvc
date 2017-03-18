package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class StudentFormController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("/home");

        return model;
    }

    //jak to zrobić by pola się same wypełniały?
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView studentForm(@ModelAttribute("existingStudent") Student student) {
        ModelAndView model = new ModelAndView();
        model.addObject("student", student);
//        model.addObject("existingStudent", student);

        model.addObject("specENUM", Specialisation.values());

        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("addStudent");
        } else if (studentService.addStudent(student)) {
            return model;

        } else {
            studentService.updateStudent(student);
            return model;
        }

    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public ModelAndView viewStudents() {
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


    //jak to zrobić by login nie byl w adresie?
    @RequestMapping(value = "/student/{login}/remove", method = RequestMethod.POST)
    public ModelAndView removeStudent(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");
        studentService.removeStudent(login);
        return model;
    }

    @RequestMapping(value = "/student/{login}/update", method = RequestMethod.POST)
    public ModelAndView updateStudent(@PathVariable("login") String login) {
        ModelAndView model = new ModelAndView("redirect:/addStudent");
        model.addObject("existingStudent", studentService.getStudentByLogin(login));
        return model;
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ModelAndView findByNameForm(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView("findByName");
        model.addObject("students", studentService.findStudentsByName(name));
        return model;
    }

    //kiedy używamy redirect?
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public ModelAndView findByName(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView("redirect:/studentsList");
        model.addObject("students", studentService.findStudentsByName(name));
        return model;
    }
}
