package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.model.BookEntity;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Named
public class NewBookBean implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private BookEntity book = new BookEntity();
    private boolean created = false;

    @Transactional
    public String createBook() {
        em.persist(book);
        book = new BookEntity();
        created = true;
//        return "book-created.xhtml";
        return null;
    }

    public boolean isCreated() {
        return created;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
