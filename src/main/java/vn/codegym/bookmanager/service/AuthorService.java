package vn.codegym.bookmanager.service;

import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.entity.Book;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public interface AuthorService {

    List<Author> findAllAuthor();

    List<Author> getAllAuthorByBookList(Long id);

    List<Author> searchAuthor(String name);

    void saveAuthor(Author author);

    void deleteAuthor(Long id);

    Author findAuthorById(Long id);
}
