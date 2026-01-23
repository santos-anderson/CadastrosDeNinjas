package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    //Adicionar uma nova missão (CREATE)
    @PostMapping("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoes) {
        return missoesServices.criarMissoes(missoes);
    }

    //Listar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesServices.listarMissoes();
    }

    //Procurar Missoes por ID(CREATE)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesServices.listarMissoesPorId(id);
    }

    //Deletar uma missão (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id) {
        missoesServices.deletarMissoesPorId(id);
    }
}
