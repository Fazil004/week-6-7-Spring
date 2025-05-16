package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    private final AddressBookRepository repository;

    @Autowired
    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AddressBook> getAllContacts() {
        log.info("Fetching all contacts");
        return repository.findAll();
    }

    @Override
    public AddressBook getContactById(Integer id) {
        log.info("Fetching contact with id: {}", id);
        return repository.findById(id).orElseThrow(() -> new AddressBookException("Contact not found for id: " + id));
    }

    @Override
    public AddressBook createContact(AddressBookDTO dto) {
        log.info("Creating new contact: {}", dto.getName());
        AddressBook contact = new AddressBook();
        BeanUtils.copyProperties(dto, contact);
        return repository.save(contact);
    }

    @Override
    public AddressBook updateContact(Integer id, AddressBookDTO dto) {
        AddressBook existingContact = getContactById(id);
        log.info("Updating contact id: {}", id);
        BeanUtils.copyProperties(dto, existingContact);
        return repository.save(existingContact);
    }

    @Override
    public void deleteContact(Integer id) {
        AddressBook contact = getContactById(id);
        log.info("Deleting contact id: {}", id);
        repository.delete(contact);
    }
}
