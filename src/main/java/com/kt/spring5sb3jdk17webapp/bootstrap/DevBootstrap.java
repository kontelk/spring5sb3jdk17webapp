package com.kt.spring5sb3jdk17webapp.bootstrap;

import com.kt.spring5sb3jdk17webapp.model.*;
import com.kt.spring5sb3jdk17webapp.repositories.AuthorRepository;
import com.kt.spring5sb3jdk17webapp.repositories.BookRepository;
import com.kt.spring5sb3jdk17webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by kontelk on 8/13/23.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
//        Author rod = new Author("Rod", "Johnson");
//        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
//        rod.getBooks().add(noEJB);
//        noEJB.getAuthors().add(rod);
//
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
    }
}

