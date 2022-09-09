package br.com.ivanilson.dto;

import br.com.ivanilson.enums.StatusPet;
import br.com.ivanilson.model.Category;
import br.com.ivanilson.model.Store;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetDto {

    private Integer id;
    private String nome;
    private StatusPet status;
    private Category category;
}
