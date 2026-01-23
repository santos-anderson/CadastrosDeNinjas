package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Procurar Ninja por ID(CREATE)
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Deletar um Ninja (DELETE)- tem que ser um metodo void
    public void deletarNinjaPorId(Long id) {
       ninjaRepository.deleteById(id);
    }

    //Alterar dados do Ninja(UPDATE)
    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
        NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
        ninjaAtualizado.setId(id);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
        return ninjaMapper.map(ninjaSalvo);
    }
    return null;
    }


}
