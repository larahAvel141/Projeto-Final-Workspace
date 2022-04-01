package br.com.tech4me.tech4directors.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4directors.shared.DiretorDTO;

public interface DiretorService {

    List<DiretorDTO> obterDiretores();

    Optional<DiretorDTO> obterDiretorPorId(String id);

    DiretorDTO cadastrarDiretor( DiretorDTO diretor);

    DiretorDTO atualizarDiretor(String id, DiretorDTO diretor);

    void deletarDiretor(String id);
    
}
