package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Procurar Missoes por ID(CREATE)
    public MissoesDTO listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    //Deletar uma missão (DELETE)
    public void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    //Alterar dados da missoes(UPDATE)
    public MissoesDTO alterarMissoes(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if(missoesExistente.isPresent()){
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtualizado);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
    }
}
