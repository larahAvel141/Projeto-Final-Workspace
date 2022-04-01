package br.com.tech4me.tech4directors.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4directors.client.FilmeFeignClient;
import br.com.tech4me.tech4directors.model.Diretor;
import br.com.tech4me.tech4directors.repository.DiretorRepository;
import br.com.tech4me.tech4directors.shared.DiretorDTO;

@Service
public class DiretorServiceImpl implements DiretorService { 

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmeFeignClient fClient;

    @Autowired
    private DiretorRepository repos;

    
    @Override
    public List<DiretorDTO> obterDiretores() {
        List<Diretor> diretores = repos.findAll();

        return diretores.stream()
        .map(d -> mapper.map(d, DiretorDTO.class))
        .collect(Collectors.toList());
    }
       
    @Override
        public Optional<DiretorDTO> obterDiretorPorId(String id) {
        Optional<Diretor> diretor = repos.findById(id);

        if (diretor.isPresent()) {
            DiretorDTO dto = mapper.map(diretor.get(), DiretorDTO.class);
            dto.setFilmes(fClient.obterFilmesPorDiretor(id));
            return Optional.of(dto);
        }
        return Optional.empty();
    }
              
    
    @Override
    public DiretorDTO atualizarDiretor(String id, DiretorDTO diretor) {
        Optional<Diretor> buscaDiretor = repos.findById(id);

        if (buscaDiretor.isPresent()) {
            Diretor atualiDiretor = mapper.map(diretor, Diretor.class);
            atualiDiretor.setId(id);
            atualiDiretor = repos.save(atualiDiretor);
    
            return mapper.map(atualiDiretor, DiretorDTO.class);
        }
        return null;

    }

    @Override
    public DiretorDTO cadastrarDiretor( DiretorDTO diretor) {
        Diretor cadasDiretor = mapper.map(diretor, Diretor.class);

        cadasDiretor = repos.save(cadasDiretor);

        return mapper.map(cadasDiretor, DiretorDTO.class);
    }

    @Override
    public void deletarDiretor(String id) {
        repos.deleteById(id);
    }
    
}
