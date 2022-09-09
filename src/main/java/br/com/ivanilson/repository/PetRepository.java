package br.com.ivanilson.repository;

import br.com.ivanilson.model.Pet;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetRepository implements PanacheRepositoryBase<Pet, Integer> {
}
