package br.com.ivanilson.repository;

import br.com.ivanilson.model.Pet;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class PetRepository implements PanacheRepositoryBase<Pet, Integer> {
}
