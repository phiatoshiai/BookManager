package vn.codegym.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.repository.AuthorRepository;
import vn.codegym.bookmanager.service.AuthorService;
import vn.codegym.bookmanager.service.BookService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookService bookService;


    @Override
    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthorByBookList(Long id) {
        return authorRepository.findAllByBookList(bookService.findBookById(id));
    }

    @Override
    public List<Author> searchAuthor(String name) {
        return authorRepository.findAllByNameContaining(name);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author findAuthorById(Long id) {

        return authorRepository.findById(id).orElse(null);
    }
}
