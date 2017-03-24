package pl.sda.service;


import pl.sda.model.Book;
import pl.sda.model.Student;

import java.util.List;

public interface BookService {

    boolean addBook(Book book);
    boolean removeBook(Book book);
    void updateBook(Book book);
    Book findBookBySignature(String signature);
    List<Book> findBookByAuthor(String authorSurname);
    List<Book> getAllBook();
    boolean isBorrowed(String signature);
    void borrow(Book book, Student student);

}
