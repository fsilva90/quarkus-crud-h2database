package org.felipe.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.felipe.model.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

}
