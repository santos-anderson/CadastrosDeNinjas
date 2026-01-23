package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Adicionar um novo Ninja (CREATE)
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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

    //Alterar dados do Ninja(UPDATE)
    public NinjaModel alterarNinja(Long id, NinjaModel ninja) {
       if(ninjaRepository.existsById(id)){
           ninja.setId(id);
           return ninjaRepository.save(ninja);
       }else{
           return null;
       }
    }

}
