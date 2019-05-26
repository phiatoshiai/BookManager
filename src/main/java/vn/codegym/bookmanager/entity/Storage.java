package vn.codegym.bookmanager.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "date_import")
    private Date date_import;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate_import() {
        return date_import;
    }

    public void setDate_import(Date date_import) {
        this.date_import = date_import;
    }
}
