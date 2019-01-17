package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.model.BookEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BooksListBean implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private String term;

    public List<BookEntity> getBooks() {
        if (term == null) {
            return em.createQuery("select b from Book b", BookEntity.class).getResultList();
        } else {
            return em.createQuery("select b from Book b where lower(b.title) like :term", BookEntity.class)
                    .setParameter("term", "%" + term.toLowerCase() + "%")
                    .getResultList();
        }
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void doSearch() {
        System.out.println("Searching");
    }
}
