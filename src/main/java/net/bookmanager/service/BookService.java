package net.bookmanager.service;

import net.bookmanager.model.Book;

import java.util.List;

/**
 * Created by Ivan on 4/29/2017.
 */
public interface BookService {
    void addBook(Book book);
    public void updateBook(Book book);
    void removeBook(int id);
    Book getBookById(int id);
    List<Book> listBooks();
}
