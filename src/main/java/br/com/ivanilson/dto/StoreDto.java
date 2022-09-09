package br.com.ivanilson.dto;

import br.com.ivanilson.model.Pet;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {

    private Integer id;
    private LocalDate dataSaida;
    private Integer quantidade;
    private Pet pet;
}
