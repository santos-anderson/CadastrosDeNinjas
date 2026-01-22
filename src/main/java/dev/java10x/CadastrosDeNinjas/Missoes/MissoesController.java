package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    //Listar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesServices.listarMissoes();
    }
}
