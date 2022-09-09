package br.com.ivanilson.factory;

import br.com.ivanilson.dto.CategoryDto;
import br.com.ivanilson.dto.PetDto;
import br.com.ivanilson.dto.StoreDto;
import br.com.ivanilson.model.Category;
import br.com.ivanilson.model.Pet;
import br.com.ivanilson.model.Store;
import br.com.ivanilson.service.CategoryService;
import br.com.ivanilson.service.PetService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class StoreFactory {

    @Inject
    PetService petService;

    @Inject
    PetFactory petFactory;

    public Store toStore(StoreDto dto){
         return Store.builder()
                .id(dto.getId())
                .dataSaida(dto.getDataSaida())
                .quantidade(dto.getQuantidade())
                .pet(dto.getPet())
                .build();
    }

    public List<Store> toListStores(List<StoreDto> dtos){
        return dtos
                .stream()
                .map(this::toStore)
                .collect(Collectors.toList());
    }

    public StoreDto toStoreDto(Store entidade){
         return StoreDto.builder()
                .id(entidade.getId())
                .dataSaida(entidade.getDataSaida())
                .quantidade(entidade.getQuantidade())
                .pet(entidade.getPet())
                .build();
    }

    public List<StoreDto> toListStoresDtos(List<Store> entidade){
        return entidade
                .stream()
                .map(this::toStoreDto)
                .collect(Collectors.toList());
    }

}
