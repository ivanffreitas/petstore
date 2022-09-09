package br.com.ivanilson.service;

import br.com.ivanilson.dto.StoreDto;
import br.com.ivanilson.factory.StoreFactory;
import br.com.ivanilson.model.Store;
import br.com.ivanilson.repository.StoreRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class StoreService {

    @Inject
    StoreRepository repository;

    @Inject
    StoreFactory factory;

    public List<StoreDto> listarStore(){
        PanacheQuery<Store> query = repository.findAll();
        List<StoreDto> dtos = query.stream().map(factory::toStoreDto).collect(Collectors.toList());
        return dtos;
    }

    public StoreDto buscarPorId(Integer id) {
        Store store = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());
        StoreDto dto = factory.toStoreDto(store);
        return dto;
    }

    public Boolean inserir(StoreDto dto) {
        Store novo = factory.toStore(dto);
        repository.persist(novo);
        return true;
    }

    public Boolean excluir(Integer id) {
        if(Objects.isNull(id)) {
            throw new IllegalArgumentException("Informe o código para realizar esta ação.");
        }
        return repository.deleteById(id);
    }

}
