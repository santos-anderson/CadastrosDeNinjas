package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Adicionar um novo Ninja (CREATE)
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //Listar todos os Ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Procurar Ninja por ID(CREATE)
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Deletar um Ninja (DELETE)- tem que ser um metodo void
    public void deletarNinjaPorId(Long id) {
       ninjaRepository.deleteById(id);
    }

}
