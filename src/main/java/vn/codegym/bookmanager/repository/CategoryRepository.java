package vn.codegym.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.bookmanager.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
