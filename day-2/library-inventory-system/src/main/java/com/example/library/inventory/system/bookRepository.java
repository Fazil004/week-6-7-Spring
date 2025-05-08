package com.example.library.inventory.system;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bookRepository extends JpaRepository<book, Long> {
    book findBytitle(String title);
    void deleteBytitle(String title);
}
