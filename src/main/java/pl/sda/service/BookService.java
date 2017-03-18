package pl.sda.service;


import pl.sda.model.Book;

public interface BookService {

    boolean addBook(Book book);
    boolean removeBook(Book book);
    void updateBook(Book book);
    Book getBookBySignature(String signature);
    boolean isBorrowed(String signature);
    void borrow(Book book);

}
