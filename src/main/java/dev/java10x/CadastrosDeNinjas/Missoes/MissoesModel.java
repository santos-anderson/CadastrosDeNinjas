package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String Dificuldade;
    //@OneToMany uma missão pode ter muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissoesModel() {
    }

    public MissoesModel(String nome, String dificuldade, List<NinjaModel> ninjas) {
        this.nome = nome;
        Dificuldade = dificuldade;
        this.ninjas = ninjas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        Dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
