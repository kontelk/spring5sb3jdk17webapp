package com.kt.spring5sb3jdk17webapp.repositories;

import com.kt.spring5sb3jdk17webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kontelk on 8/13/23.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
