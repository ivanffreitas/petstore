package br.com.ivanilson.dto;

import br.com.ivanilson.model.Category;
import br.com.ivanilson.model.Store;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private Integer id;
    private String nome;
    private String status;
    private Integer category;
    private Integer store;
}
