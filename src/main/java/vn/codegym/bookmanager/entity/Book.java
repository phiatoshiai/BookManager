package vn.codegym.bookmanager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "public_year")
    private int public_year;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "book_has_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> authorList;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "book_category_id")
    private Category bookCategory;

    public Category getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Category bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublic_year() {
        return public_year;
    }

    public void setPublic_year(int public_year) {
        this.public_year = public_year;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Book [id=%d, name='%s']%n",
                id, name);
        if (authorList != null) {
            for (Author author : authorList) {
                result += String.format(
                        "Author[id=%d, name='%s']%n",
                        author.getId(), author.getName());
            }
        }

        return result;
    }
}
