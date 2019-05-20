package vn.codegym.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.entity.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByNameContaining(String name);

    List<Author> findAllByBookList(Book books);
}
