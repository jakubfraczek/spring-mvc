package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView libView() {
        ModelAndView model = new ModelAndView("library");

        return model;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public ModelAndView addBook() {
        ModelAndView model = new ModelAndView("addBook");
        model.addObject("book", new Book());

        return model;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/library/bookList");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("addBook");
        } else {
            bookService.addBook(book);
            return model;
        }

    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public ModelAndView viewBooks() {
        ModelAndView model = new ModelAndView("bookList");

        model.addObject("books", bookService.getAllBook());
        return model;
    }

    @RequestMapping(value = "/remove/{signature}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("signature") String signature) {
        ModelAndView model = new ModelAndView("redirect:/library/bookList");


        return model;
    }

}
