package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
       List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        if(ninjaService.listarNinjasPorId(id) != null){
            NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com ID: " + id + " não encontrado!!");
        }
    }

    //Alterar dados do Ninja(UPDATE)

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
       if(ninjaService.listarNinjasPorId(id) != null){
            NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaDTO);
           return ResponseEntity.ok(ninja);

       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com ID: " + id + " não encontrado!!");
       }
    }

    //Deletar Ninja(DELETE)

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
      if(ninjaService.listarNinjasPorId(id) != null){
          ninjaService.deletarNinjaPorId(id);
          return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso.");
      }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com ID: " + id + " não encontrado!!");
      }
    }


}
