package com.practice.rest.address;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/address")
class AddressController{
    private final AddressRepository addressRepository;
    public AddressController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
        this.addressRepository.saveAll(List.of(
                new Address("Germany","Munich","Somethingstrasse",4),
                new Address()
        ));
    }

    @GetMapping
    Iterable<Address> getAddress(){
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Address> getAddressById(@PathVariable UUID id){
        return addressRepository.findById(id);
    }

    @PostMapping
    Address postPerson(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    ResponseEntity<Address> putAddress(@PathVariable UUID id, @RequestBody Address address){
        return (addressRepository.existsById(id)
                ? new ResponseEntity<>(addressRepository.save(address), HttpStatus.OK)
                : new ResponseEntity<>(addressRepository.save(address),HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable UUID id){
        addressRepository.deleteById(id);
    }
}
