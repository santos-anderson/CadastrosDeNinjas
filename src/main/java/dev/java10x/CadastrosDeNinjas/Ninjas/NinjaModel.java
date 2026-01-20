package dev.java10x.CadastrosDeNinjas.Ninjas;



import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//Entity ele transforma a classe em uma tabela no banco de dados
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne um ninja pode ter uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //nome da coluna que vai receber a chave estrangeira
    private MissoesModel missoes;


    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }



    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;


    }
}
