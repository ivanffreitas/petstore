package br.com.ivanilson.factory;

import br.com.ivanilson.dto.StoreDto;
import br.com.ivanilson.model.Store;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class StoreFactory {

    public Store toStore(StoreDto dto){
        return Store.builder()
                .id(dto.getId())
                .dataSaida(dto.getDataSaida())
                .quantidade(dto.getQuantidade())
                //.pet(dto.getPet())
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
                //.pet(entidade.getPet())
                .build();
    }

    public List<StoreDto> toListStoresDtos(List<Store> entidade){
        return entidade
                .stream()
                .map(this::toStoreDto)
                .collect(Collectors.toList());
    }

}
