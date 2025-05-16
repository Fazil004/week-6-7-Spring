package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final IAddressBookService service;

    @Autowired
    public AddressBookController(IAddressBookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        log.info("GET all contacts called");
        List<AddressBook> list = service.getAllContacts();
        return new ResponseEntity<>(list, HttpStatus.OK);

