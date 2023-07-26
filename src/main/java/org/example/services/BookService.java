package org.example.services;

import org.example.entities.Book;

import java.util.List;

public interface BookService {
    String  saveBook(Book book);

    void saveAllBooks(List<Book> books);

    void findAll();
    Book findById(Long bookId);

    Book  update(Long id,Book book);

    void deleteBookByName(Long id);

    void clearBookTable();

    void dropTable();
    public  void updaTeBook2(Long id, Book book);

    Book findById2(Long id);

    String  deleteBookByName2(String name);

    String deleteBookByNameAndAuthor3(String name, String author);
}
