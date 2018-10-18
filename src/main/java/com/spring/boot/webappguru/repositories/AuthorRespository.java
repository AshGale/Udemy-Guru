package com.spring.boot.webappguru.repositories;

import com.spring.boot.webappguru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {
}
