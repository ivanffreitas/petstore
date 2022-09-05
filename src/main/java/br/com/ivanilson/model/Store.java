package br.com.ivanilson.model;

import br.com.ivanilson.enums.StatusStore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PSTB002_STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_ID")
    private Integer id;

    @Column(name = "S_DATA_ENTRADA")
    private LocalDate dataEntrada;

    @Column(name = "S_DATA_SAIDA")
    private LocalDate dataSaida;

    @Column(name = "S_DESCRICAO")
    private String descricao;

    @Column(name = "S_OBS")
    private String obs;

    @OneToMany(mappedBy = "store")
    private List<Pet> pets;

    @Enumerated(EnumType.STRING)
    @Column(name = "S_STATUS")
    private StatusStore status;

}
