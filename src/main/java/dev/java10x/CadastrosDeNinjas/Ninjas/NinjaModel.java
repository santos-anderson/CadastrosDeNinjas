package dev.java10x.CadastrosDeNinjas.Ninjas;



import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity ele transforma a classe em uma tabela no banco de dados
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    //@ManyToOne um ninja pode ter uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //nome da coluna que vai receber a chave estrangeira
    private MissoesModel missoes;

}
