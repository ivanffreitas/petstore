package br.com.ivanilson.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private Integer id;
    private String nome;
    private Integer status;
    private Integer category;
    private Integer stores;
}
