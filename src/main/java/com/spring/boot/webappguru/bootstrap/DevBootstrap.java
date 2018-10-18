package com.spring.boot.webappguru.bootstrap;

import com.spring.boot.webappguru.model.Author;
import com.spring.boot.webappguru.model.Book;
import com.spring.boot.webappguru.model.Publisher;
import com.spring.boot.webappguru.repositories.AuthorRepository;
import com.spring.boot.webappguru.repositories.BookRepository;
import com.spring.boot.webappguru.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisherUk = new Publisher("JavaPrints","Londonrd Brighton","BN11EE");
        Book ddd = new Book("Domain Driven Design", "1234", publisherUk);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(publisherUk);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisherIe = new Publisher("Ink Inc","Dublin City Docks","D4");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherIe );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(publisherIe);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
