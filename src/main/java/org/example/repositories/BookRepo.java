package org.example.repositories;

import org.example.entities.Book;

import java.util.List;

public interface BookRepo  {
    String saveBook(Book book);
    void saveAllBooks(List<Book> books);
    void findAll();

    Book findById(Long bookId);

    Book update(Long id, Book book);

    void deleteBookName(Long bookId);

    void clearBookTable();

    void dropTable();

    void upDateBook2(Long id, Book book);

    Book findById2(Long id);

    String deleteBookName2(String name);

    String deleteBookByNameAndAuthor3(String name,String author);
}
