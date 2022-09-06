package br.com.ivanilson.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {

    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String descricao;
    private String obs;
    private Integer pets;
    private Integer status;
}
