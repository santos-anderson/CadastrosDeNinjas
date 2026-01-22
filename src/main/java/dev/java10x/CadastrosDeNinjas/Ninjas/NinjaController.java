package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/procurar/{id}")
    public String procurarPorId(@PathVariable Long id) {
        return "Procurando por ID: " + id;
    }

    //Alterar dados do Ninja(UPDATE)

    @PutMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id) {
        return "Alterando Ninja com ID: " + id;
    }

    //Deletar Ninja(DELETE)

    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        return "Deletando Ninja com ID: " + id;
    }


}
