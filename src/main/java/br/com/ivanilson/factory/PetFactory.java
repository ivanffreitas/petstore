package br.com.ivanilson.factory;

import br.com.ivanilson.dto.PetDto;
import br.com.ivanilson.model.Pet;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PetFactory {
   public Pet toPet(PetDto dto){
         return Pet.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .status(dto.getStatus())
                .category(dto.getCategory())
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
                .status(entidade.getStatus())
                .category(entidade.getCategory())
                .build();
    }

    public List<PetDto> toListPetDtos(List<Pet> entidades){
        return entidades
                .stream()
                .map(this::toPetDto)
                .collect(Collectors.toList());
    }
}
