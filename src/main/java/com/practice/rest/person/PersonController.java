package com.practice.rest.person;

import com.practice.rest.address.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
class PersonController{
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
        this.personRepository.saveAll(List.of(
                new Person("Pepi","Pompata",33,"Skiing",
                        new Address("Switzerland","Geneva","Liberty Str.",13)),
                new Person("Sepiq", "Pipala", 50, null,
                        new Address()),
                new Person()
        ));
    }


    @GetMapping
    Iterable<Person> getPerson(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Person> getPersonById(@PathVariable UUID id){
        return personRepository.findById(id);
    }

    @PostMapping
    Person postPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> putPerson(@PathVariable UUID id, @RequestBody Person person){
        return (personRepository.existsById(id)
                ? new ResponseEntity<>(personRepository.save(person), HttpStatus.OK)
                : new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable UUID id){
        personRepository.deleteById(id);
    }
}
