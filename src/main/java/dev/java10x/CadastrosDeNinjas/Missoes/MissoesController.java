package dev.java10x.CadastrosDeNinjas.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesServices) {
        this.missoesService = missoesServices;
    }

    //Adicionar uma nova missão (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<?> criarMissoes(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    //Listar todas as missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //Procurar Missoes por ID(CREATE)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        if(missoesService.listarMissoesPorId(id) != null){
            MissoesDTO missoes = missoesService.listarMissoesPorId(id);
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão Com ID: " + id + " não encontrada!!");
        }
    }

    //Deletar uma missão (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoesPorId(@PathVariable Long id) {
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("Missão com ID: " + id + " deletada com sucesso.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID: " + id + " não encontrada!!");
        }
    }

    //Alterar dados da missão(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        if(missoesService.listarMissoesPorId(id) != null){
            MissoesDTO missoes = missoesService.alterarMissoes(id, missoesDTO);
            return ResponseEntity.ok(missoes);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID: " + id + " não encontrada!!");
        }
    }

}
