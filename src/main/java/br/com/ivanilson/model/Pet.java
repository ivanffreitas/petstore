package br.com.ivanilson.model;

import br.com.ivanilson.enums.StatusPet;
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
@Table(name = "PSTB004_PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Integer id;

    @Column(name = "P_NOME")
    private String nome;

    @Column(name = "P_STATUS")
    private StatusPet status;

    @ManyToOne
    @JoinColumn(name = "C_ID_CATEGORIA")
    private Category category;

    @JsonBackReference
    @OneToMany(mappedBy = "pet")
    private List<Store> stores;

}
