package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesDTO {

    private Long id;
    private String nome;
    private String Dificuldade;

}
