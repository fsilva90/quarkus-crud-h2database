package org.felipe.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.felipe.model.Person;
import org.felipe.repository.PersonRepository;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository repository;

    public List<Person> findAllPersons() {
        return this.repository.listAll();
    }

    @Transactional
    public void createPerson(Person person) {
        this.repository.persist(person);
    }

    @Transactional
    public void updatePerson(Person person) throws Exception {
        Person p = this.repository.findByIdOptional(person.getId())
                .orElseThrow(() -> new Exception("Person not found: " + person));
        p.setName(person.getName());

        this.repository.persist(p);
    }

    @Transactional
    public Boolean deletePerson(Long id) {
        return this.repository.deleteById(id);
    }
}
