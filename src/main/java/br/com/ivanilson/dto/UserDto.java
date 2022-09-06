package br.com.ivanilson.dto;

import br.com.ivanilson.enums.StatusUser;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer status;
}
