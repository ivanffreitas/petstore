package br.com.ivanilson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PSTB003_CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private Integer id;

    @Column(name = "C_NOME")
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Pet> pets;
}
