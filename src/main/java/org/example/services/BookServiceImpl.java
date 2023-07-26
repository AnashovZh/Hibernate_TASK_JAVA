package org.example.services;

import org.example.entities.Book;
import org.example.repositories.BookRepo;
import org.example.repositories.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepo bookRepo=new BookRepository();

    @Override
    public String saveBook(Book book) {
        return bookRepo.saveBook(book);
    }

    @Override
    public void saveAllBooks(List<Book> books) {
        bookRepo.saveAllBooks(books);
    }

    @Override
    public void findAll() {
        bookRepo.findAll();
    }

    @Override
    public Book findById(Long bookId) {
//        bookRepo.findById(bookId).orElseThrow(()->new RuntimeException( "Book with id  :"+bookId+"not found!))
        return bookRepo.findById(bookId);
    }

    @Override
    public Book update(Long id, Book book) {
       return bookRepo.update(id,book);
    }

    @Override
    public void deleteBookByName(Long id) {
        bookRepo.deleteBookName(id);
    }

    @Override
    public void clearBookTable() {
     bookRepo.clearBookTable();
    }

    @Override
    public void dropTable() {
        bookRepo.dropTable();
    }

    @Override
    public void updaTeBook2(Long id, Book book) {
        bookRepo.upDateBook2(id,book);
    }

    @Override
    public Book findById2(Long id) {
        return bookRepo.findById2(id);
    }

    @Override
    public String deleteBookByName2(String name) {
        return bookRepo.deleteBookName2(name);
    }

    @Override
    public String deleteBookByNameAndAuthor3(String name, String author) {
        return bookRepo.deleteBookByNameAndAuthor3(name,author);
    }
}
