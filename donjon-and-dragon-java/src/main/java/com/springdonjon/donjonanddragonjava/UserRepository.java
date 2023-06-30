package com.springdonjon.donjonanddragonjava;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface UserRepository extends JpaRepository<Personnage, Integer> {
    List<Personnage> findAll();

}
