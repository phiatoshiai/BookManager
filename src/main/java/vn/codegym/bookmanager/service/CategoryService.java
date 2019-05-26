package vn.codegym.bookmanager.service;

import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategory();

    void saveCategory(Category category);
}
