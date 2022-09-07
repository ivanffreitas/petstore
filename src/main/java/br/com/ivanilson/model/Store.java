package br.com.ivanilson.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "PSTB002_STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_ID")
    private Integer id;

    @Column(name = "S_DATA_SAIDA")
    private LocalDate dataSaida;

    @Column(name = "S_QUANTIDADE")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "P_ID_PET")
    private Pet pet;

}
