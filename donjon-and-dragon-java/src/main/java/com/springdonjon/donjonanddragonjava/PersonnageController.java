package com.springdonjon.donjonanddragonjava;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class PersonnageController {

    private UserRepository userRepository;
    private int idCount;
//    private final PersonnageDao userRepository;

    public PersonnageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/personnages")
    public Iterable<Personnage> getPersonnages() {
        Iterable<Personnage> personnages = userRepository.findAll();
        return personnages;
    }

    @PostMapping("/personnages")
    public Personnage ajouterPersonnage(
            @RequestBody Personnage request) {

        String name = request.getName();
        String type = String.valueOf(request.getType());

        Personnage newPersonnage = new Personnage(name, PersonType.valueOf(type));
        userRepository.save(newPersonnage);
        return newPersonnage;
    }

    @GetMapping("/personnages/{id}")
    public Personnage findPersonnage(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PutMapping("/personnages/{id}")
    public Personnage updatePersonnage(@PathVariable("id") int id,
                                       @RequestBody Personnage request) {

        Personnage personnage = userRepository.findById(id);

        personnage.setName(request.getName());
        personnage.setType(request.getType());

        return userRepository.save(personnage);
    }

    @DeleteMapping("/personnages/{id}")
    public void deletePersonnage(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }
}
