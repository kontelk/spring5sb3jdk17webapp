package com.kt.spring5sb3jdk17webapp.repositories;

import com.kt.spring5sb3jdk17webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kontelk on 8/13/23.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
