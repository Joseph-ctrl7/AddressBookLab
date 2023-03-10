package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long>{
    AddressBook findById(long id);
}
