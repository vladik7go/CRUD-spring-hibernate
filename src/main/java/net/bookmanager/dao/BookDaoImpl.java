package net.bookmanager.dao;

import net.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Ivan on 4/29/2017.
 */
public class BookDaoImpl implements BookDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDaoImpl.class);
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        LOGGER.info(String.format("The book successfuly saved. Book details: %s", book));
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        LOGGER.info("The book was successfully changed. Book details: " + book);

    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if (book != null) session.delete(book);
        LOGGER.info("The book " + book + " was deleted.");

    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        LOGGER.info("The book was successfully loaded: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBook() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book").list();

        return books;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
