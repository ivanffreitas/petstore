package br.com.ivanilson.factory;

import br.com.ivanilson.dto.PetDto;
import br.com.ivanilson.enums.StatusPet;
import br.com.ivanilson.model.Pet;
import br.com.ivanilson.model.Store;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PetFactory {

    public Pet toPet(PetDto dto){
        return Pet.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .status(StatusPet.toEnum(dto.getStatus()))
                //.category(dto.getCategory())
                //.stores()
                .build();
    }

    public List<Pet> toListPets(List<PetDto> dtos){
        return dtos
                .stream()
                .map(this::toPet)
                .collect(Collectors.toList());
    }
    public PetDto toPetDto(Pet entidade){
        return PetDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .status(entidade.getStatus().getCodigo())
                .category(entidade.getCategory().getId())
                .stores(entidade.getStores().get(0).getId())
                .build();
    }

    public List<PetDto> toListPetDtos(List<Pet> entidade){
        return entidade
                .stream()
                .map(this::toPetDto)
                .collect(Collectors.toList());
    }
}
