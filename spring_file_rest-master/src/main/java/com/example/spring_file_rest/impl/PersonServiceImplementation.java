package com.example.spring_file_rest.impl;

import com.example.spring_file_rest.entity.Person;
import com.example.spring_file_rest.repository.PersonRepository;
import com.example.spring_file_rest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements PersonService
{
    private final PersonRepository repository;
    public PersonServiceImplementation(PersonRepository repository){this.repository = repository;}
    @Override
    public Optional<Person>findById(Long id)
    {
        return repository.findById(id);
    }
    @Override
    public List<Person> findAll(){return repository.findAll();}

    @Override
    public void save(List<Person> personList) {
        repository.saveAll(personList);
    }

    @Override
    public Person findByIin(Long iin) {
        return repository.findByIin(iin).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
