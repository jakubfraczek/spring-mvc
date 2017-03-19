package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Book;
import pl.sda.model.Specialisation;
import pl.sda.model.Student;
import pl.sda.service.BookService;

import javax.validation.Valid;

@RequestMapping("/library")
@Controller
public class LibraryController {

    @Autowired
    @Qualifier("bookServiceSQL")
    private BookService bookService;

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public ModelAndView studentBook() {
        ModelAndView model = new ModelAndView();
        model.addObject("book", new Book());

        return model;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/bookList");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("addBook");
        } else {
            bookService.addBook(book);
            return model;
        }

    }
}
