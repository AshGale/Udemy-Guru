package com.spring.boot.webappguru.repositories;

import com.spring.boot.webappguru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
