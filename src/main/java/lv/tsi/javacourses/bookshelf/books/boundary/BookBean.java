package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.model.BookEntity;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.io.Serializable;

@ViewScoped
@Named
public class BookBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private Long id;
    private BookEntity book;

    public void openBook() {
        System.out.println("Opening book " + id);
        book = em.find(BookEntity.class, id);
    }

    public BookEntity getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
