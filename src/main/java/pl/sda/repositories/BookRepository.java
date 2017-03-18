package pl.sda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findBySignature(String signature);
    List<Book> findByAuthorName(String authorName);

}
