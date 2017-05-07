package net.bookmanager.dao;

import net.bookmanager.model.Book;

import java.util.List;

/**
 * Created by Ivan on 4/29/2017.
 */
public interface BookDao {
    void addBook(Book book);
    void updateBook(Book book);
    void removeBook(int id);
    Book getBookById(int id);
    List<Book> listBook();
}
