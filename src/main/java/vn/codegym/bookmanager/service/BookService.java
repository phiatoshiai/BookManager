package vn.codegym.bookmanager.service;

import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Book;

import java.util.List;


@Service
public interface BookService {

       List<Book> getAllBook();

    List<Book> getBookByAuthorList(Long id);

    List<Book> getBookByBookCategoryId(Long id);

    void saveBook(Book book);

    void deleteBook(Long id);

    Book findBookById(Long id);
}
