package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Book;
import pl.sda.model.Student;
import pl.sda.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service("bookServiceSQL")
public class BookServiceSQL implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean addBook(Book book) {
        return bookRepository.save(book) != null;
    }

    @Override
    public boolean removeBook(Book book) {
        bookRepository.delete(book);
        return bookRepository.findByAuthorSurname(book.getAuthorSurname()) == null;
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookBySignature(String signature) {
        return bookRepository.findBySignature(signature);
    }

    @Override
    public List<Book> findBookByAuthor(String authorSurname) {
        return bookRepository.findByAuthorSurname(authorSurname);
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookRepository.findAll();
        return books == null ? new ArrayList<>() : books;
    }

    @Override
    public boolean isBorrowed(String signature) {
        return bookRepository.findBySignature(signature).getCurrentOwner() != null;
    }

    @Override
    public void borrow(Book book, Student student) {
        book.setCurrentOwner(student);
        bookRepository.save(book);
    }
}
