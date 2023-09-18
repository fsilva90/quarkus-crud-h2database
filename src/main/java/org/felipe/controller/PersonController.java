package org.felipe.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.felipe.model.Person;
import org.felipe.service.PersonService;

import java.util.List;

@Path("/person")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    public List<Person> findAllPersons() {
        return personService.findAllPersons();
    }

    @POST
    public void createPerson(Person person) {
        this.personService.createPerson(person);
    }

    @PUT
    public void updatePerson(Person person) throws Exception {
        this.personService.updatePerson(person);
    }

    @DELETE
    @Path("{id}")
    public Boolean deletePerson(@PathParam("id") Long id) {
        return this.personService.deletePerson(id);
    }
}
