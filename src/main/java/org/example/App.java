package org.example;

import org.example.configuration.DataBaseConnection;
import org.example.entities.Book;
import org.example.services.BookService;
import org.example.services.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DataBaseConnection.creatSessionFactory();
        BookService bookService = new BookServiceImpl();
        while (true) {
            System.out.println("""
                    \n1.saveBook
                    \n2.saveAllBooks
                    \n3.findAll
                    \n4.findById
                    \n5.updateBookById 
                    \n6.deleteBookById
                    \n7.clears book
                    \n8.dropTable                   
                    """);

            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    bookService.saveBook(new Book(
                            "Syngan kylych", "Tologon Kasymbekov", BigDecimal.valueOf(1000)
                    ));

                }
                case "2" -> {
                    bookService.saveAllBooks(List.of(
                            new Book("Kylym karytar bir kyn", "CXhyngyz Aitmatov", BigDecimal.valueOf(900)),
                            new Book("Bktyluuluktun formulasy", "Chubak ajy Jalilov", BigDecimal.valueOf(1900)),
                            new Book("Ochpos omur", "Abdyshykyr", BigDecimal.valueOf(1000)),
                            new Book("Min bir tun", "Arlen", BigDecimal.valueOf(200))));
                }
                case "3" -> {
                    bookService.findAll();
                }
                case "4" -> {
                    System.out.println("Write id for found");
                    System.out.println(bookService.findById(1L));
                }
                case "5" -> {
                    System.out.println("Update book by id");
                    bookService.update(1L, new Book("Toolor kulaganda", "Chyngyz",
                            BigDecimal.valueOf(123)));
                }
                case "6" -> {
                    System.out.println("Method delete book by id");
                    bookService.deleteBookByName(5L);
                }
                case "7" -> {
                    System.out.println("Clear books ");
                    bookService.clearBookTable();
                }
                case "8" -> {
                    System.out.println("Drop table");
                    bookService.dropTable();
                }
                case "9"->{
                    System.out.println("Update book last");
                    bookService.updaTeBook2(16L,new Book("Kapital","Karl Marks",BigDecimal.valueOf(2000)));
                }
                case "10"->{
                    System.out.println("Find by id book");
                    System.out.println(bookService.findById2(16L));
                }
                case "11"->{
                    System.out.println("Delete book by name");
                    System.out.println(bookService.deleteBookByName2("Ochpos omur"));
                }
                case "12"->{
                    System.out.println("Deleted bood by name and author");
                    bookService.deleteBookByNameAndAuthor3();
                }
            }
        }
    }
}
