package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesServices {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesServices(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Adicionar uma nova missão (CREATE)
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    //Listar todas as Missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Procurar Missoes por ID(CREATE)
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Deletar uma missão (DELETE)
    public void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
