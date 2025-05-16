package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    List<AddressBook> getAllContacts();

    AddressBook getContactById(Integer id);

    AddressBook createContact(AddressBookDTO addressBookDTO);

    AddressBook updateContact(Integer id, AddressBookDTO addressBookDTO);

    void deleteContact(Integer id);
}
