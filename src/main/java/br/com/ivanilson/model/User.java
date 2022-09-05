package br.com.ivanilson.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PSTB001_STATUS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_ID")
    private Integer id;

    @Column(name = "U_NOME")
    private String nome;

    @Column(name = "U_EMAIL")
    private String email;

    @Column(name = "U_SENHA")
    private String senha;

    @Column(name = "U_STATUS")
    private String status;

}
