package vn.codegym.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorList(Author authors);
    List<Book> findBookByBookCategoryId(Long id);
}
