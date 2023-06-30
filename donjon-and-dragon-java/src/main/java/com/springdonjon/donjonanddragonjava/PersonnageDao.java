package com.springdonjon.donjonanddragonjava;

import java.util.List;

public interface PersonnageDao {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage personnage);
    void remove(int id);
}
