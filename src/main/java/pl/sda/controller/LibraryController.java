package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.service.BookService;

@RequestMapping("/library")
@Controller
public class LibraryController {

    @Autowired
    @Qualifier("serviceStudentSQL")
    private BookService bookService;

    public ModelAndView library(){
        ModelAndView model = new ModelAndView();

        return model;
    }
}
