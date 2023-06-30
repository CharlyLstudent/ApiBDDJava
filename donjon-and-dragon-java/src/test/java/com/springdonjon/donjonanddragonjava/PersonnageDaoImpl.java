package com.springdonjon.donjonanddragonjava;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnageDaoImpl implements PersonnageDao {

    private final List<Personnage> personnages = new ArrayList<>();



    private int idCount;

    public PersonnageDaoImpl() {
        idCount = 0;
        this.save(new Personnage("michel", PersonType.GUERRIER, idCount));
        this.save(new Personnage("christophe", PersonType.GUERRIER, idCount));
        this.save(new Personnage("cedric", PersonType.MAGICIEN, idCount));
    }

    @Override
    public List<Personnage> findAll() {
        return personnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnage : personnages) {
            if (personnage.getId() == id) {
                return personnage;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        idCount++;
        return personnage;
    }

    public void delete(int id){
        personnages.remove(this.findById(id));
    }
}
