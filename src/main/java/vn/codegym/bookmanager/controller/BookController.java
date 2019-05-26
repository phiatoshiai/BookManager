package vn.codegym.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.codegym.bookmanager.entity.Author;
import vn.codegym.bookmanager.entity.Book;
import vn.codegym.bookmanager.entity.Category;
import vn.codegym.bookmanager.service.AuthorService;
import vn.codegym.bookmanager.service.BookService;
import vn.codegym.bookmanager.service.CategoryService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/index")
    public String home(ModelMap map) {
        List<Book> allBook = bookService.getAllBook();
        map.addAttribute("bookList", allBook);

        map.addAttribute("book", new Book());
        List<Author> authors = authorService.findAllAuthor();

        map.addAttribute("author", authors);

        map.addAttribute("authorNew", new Author());

        map.addAttribute("category", new Category());

        map.addAttribute("categoryNew", new Category());

        return "index";
    }

    /*
    Trang chủ
     */
    @RequestMapping("/home")
    public String show(ModelMap map) {
        List<Book> allBook = bookService.getAllBook();
        map.addAttribute("bookList", allBook);
        return "home";
    }

    /*
    Thêm mới sách
     */
    @GetMapping("/addBook")
    public String addBook(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        List<Author> authors = authorService.findAllAuthor();
        modelMap.addAttribute("author", authors);
        return "addBook";
    }

    /*
    Thêm mới tác giả
    */
    @GetMapping("/addAuthor")
    public String addAuthor(ModelMap modelMap) {
        modelMap.addAttribute("author", new Author());
        return "addAuthor";
    }

    /*
    Cập nhật thêm mới tác giả
     */
    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("authorNew") Author author, ModelMap modelMap) {
        authorService.saveAuthor(author);
        return "redirect:/index";
    }

    /*
    Cập nhật thêm mới thể loại
 */
    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("categoryNew") Category category, ModelMap modelMap) {
        categoryService.saveCategory(category);
        return "redirect:/index";
    }

    /*
    Chỉnh sửa thông tin sách
     */
    @GetMapping("/editBook")
    public String editBook(@RequestParam("id") Long id, ModelMap modelMap) {
        Book editBook = bookService.findBookById(id);
        modelMap.addAttribute("book", editBook);
        List<Author> authorEdit = authorService.findAllAuthor();
        modelMap.addAttribute("author", authorEdit);
        List<Category> categoryEdit = categoryService.getAllCategory();
        modelMap.addAttribute("category", categoryEdit);
        return "editBook";
    }

    /*
    Cập nhật sau khi chỉnh sửa sách
     */
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/home";
    }

    /*
    Xóa sách
     */
    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") Long idDel) {
        bookService.deleteBook(idDel);
        return "redirect:/home";
    }

    /*
    Tìm kiếm sách thêm tên / kí tự
     */
    @PostMapping("/searchBookByAuthor")
    public String search(@RequestParam("name") String name, ModelMap modelMap) {
        List<Author> authors = authorService.searchAuthor(name);
        modelMap.addAttribute("author", authors);
        return "findBookByAuthor";
    }
}
