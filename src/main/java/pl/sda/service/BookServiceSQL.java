package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Book;
import pl.sda.repositories.BookRepository;

@Service("bookServiceSQL")
public class BookServiceSQL implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean removeBook(Book book) {
        return false;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Book getBookBySignature(String signature) {
        return null;
    }

    @Override
    public boolean isBorrowed(String signature) {
        return false;
    }

    @Override
    public void borrow(Book book) {

    }
}
