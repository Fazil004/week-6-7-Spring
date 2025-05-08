package com.example.library.inventory.system;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class bookServiceImpl implements bookService {

    @Autowired
    private bookRepository BookRepository;

    @Override
    public book addBook(book Book) {
        return BookRepository.save(Book);
    }


    @Override
    public List<book> displayAll() {
        return BookRepository.findAll();
    }

    @Override
    public book findByTitle(String title) {
        return BookRepository.findBytitle(title);
    }

    @Override
    public void deleteByTitle(String title) {
        BookRepository.deleteBytitle(title);

    }
}
