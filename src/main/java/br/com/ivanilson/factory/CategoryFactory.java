package br.com.ivanilson.factory;

import br.com.ivanilson.dto.CategoryDto;
import br.com.ivanilson.model.Category;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CategoryFactory {

    public Category toCategory(CategoryDto dto){
        return Category.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    public List<Category> toListCagory(List<CategoryDto> dtos){
        return dtos
                .stream()
                .map(this::toCategory)
                .collect(Collectors.toList());
    }

    public CategoryDto toCategoryDto(Category entidade){
        return CategoryDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .build();
    }

    public List<CategoryDto> toListCagoryDto(List<Category> entidade){
        return entidade
                .stream()
                .map(this::toCategoryDto)
                .collect(Collectors.toList());
    }

}
