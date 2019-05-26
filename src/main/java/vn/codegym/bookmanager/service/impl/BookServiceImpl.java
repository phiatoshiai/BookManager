package vn.codegym.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.entity.Book;
import vn.codegym.bookmanager.repository.AuthorRepository;
import vn.codegym.bookmanager.repository.BookRepository;
import vn.codegym.bookmanager.service.AuthorService;
import vn.codegym.bookmanager.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBookByAuthorList(Long id) {
        return bookRepository.findAllByAuthorList(authorService.findAuthorById(id));
    }

    @Override
    public List<Book> getBookByBookCategoryId(Long id) {
        return bookRepository.findBookByBookCategoryId(id);
    }

    @Override
    public void saveBook(Book book) {

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }

    @Override
    public Book findBookById(Long id) {

        return bookRepository.findById(id).orElse(null);
    }
}
