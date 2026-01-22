package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesServices {

    private final MissoesRepository missoesRepository;

    public MissoesServices(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as Missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }
}
