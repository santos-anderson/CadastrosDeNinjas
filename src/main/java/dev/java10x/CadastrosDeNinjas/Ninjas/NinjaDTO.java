package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private MissoesModel missoes;

    private String rank;

}
