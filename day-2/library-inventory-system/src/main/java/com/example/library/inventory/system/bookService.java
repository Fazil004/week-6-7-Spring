package com.example.library.inventory.system;
import java.util.List;

public interface bookService {
    book addBook(book Book);
    List<book> displayAll();
    book findByTitle (String title);
    void deleteByTitle (String title);

}
