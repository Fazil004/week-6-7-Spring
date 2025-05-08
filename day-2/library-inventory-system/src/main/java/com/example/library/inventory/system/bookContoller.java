package com.example.library.inventory.system;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class bookContoller {

    @Autowired
    private bookService bookservice;

    @PostMapping
    public book addBook(@RequestBody book Book) {
        return bookservice.addBook(Book);
    }

    @GetMapping
    public List<book> displayAll() {
        return bookservice.displayAll();
    }

    @GetMapping("/{title}")
    public book findByTitle(@PathVariable String title) {
        return bookservice.findByTitle(title);
    }

    @DeleteMapping("/{title}")
    public void deleteByTitle(@PathVariable String title) {
        bookservice.deleteByTitle(title);
    }
}
