package br.com.ivanilson.service;

import br.com.ivanilson.dto.PetDto;
import br.com.ivanilson.factory.PetFactory;
import br.com.ivanilson.model.Pet;
import br.com.ivanilson.repository.PetRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class PetService {

    @Inject
    PetRepository repository;

    @Inject
    PetFactory factory;

    public List<PetDto> listarPet(){
        PanacheQuery<Pet> query = repository.findAll();
        List<PetDto> dtos = query.stream().map(factory::toPetDto).collect(Collectors.toList());
        return dtos;
    }

    public PetDto buscarPorId(Integer id) {
        Pet pet = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());
        PetDto dto = factory.toPetDto(pet);
        return dto;
    }

    public Boolean inserir(PetDto dto) {
        Pet novo = factory.toPet(dto);
        repository.persist(novo);
        return true;
    }

    public Boolean alterar(PetDto dto) {
        Pet pet = repository.findByIdOptional(dto.getId()).orElseThrow( () -> new NotFoundException() );
        pet.setNome(dto.getNome());
        pet.setStatus(dto.getStatus());
        pet.setCategory(dto.getCategory());
        repository.persist(pet);
        return true;
    }

}
