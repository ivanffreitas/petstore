package br.com.ivanilson.model;

import lombok.*;

import javax.persistence.*;

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
    private String status;

    @ManyToOne
    @JoinColumn(name = "C_ID_CATEGORIA")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "S_ID_STORE")
    private Store store;

}
