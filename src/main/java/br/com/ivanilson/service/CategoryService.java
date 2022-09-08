package br.com.ivanilson.service;

import br.com.ivanilson.dto.CategoryDto;
import br.com.ivanilson.factory.CategoryFactory;
import br.com.ivanilson.model.Category;
import br.com.ivanilson.repository.CategotyRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CategoryService {

    @Inject
    CategotyRepository repository;

    @Inject
    CategoryFactory factory;

    public List<CategoryDto> listarCategory(){
        PanacheQuery<Category> query = repository.findAll();
        List<CategoryDto> dtos = query.stream().map(factory::toCategoryDto).collect(Collectors.toList());

        return dtos;
    }

    public CategoryDto buscarPorId(Integer id) {
        Category category = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());
        CategoryDto dto = factory.toCategoryDto(category);
        return dto;
    }

    public Boolean inserir(CategoryDto dto) {
        Category novo = factory.toCategory(dto);
        repository.persist(novo);
        return true;
    }

}
