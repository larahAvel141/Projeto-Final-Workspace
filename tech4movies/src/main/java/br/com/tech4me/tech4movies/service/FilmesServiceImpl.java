package br.com.tech4me.tech4movies.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4movies.model.Filmes;
import br.com.tech4me.tech4movies.repository.FilmesRepository;
import br.com.tech4me.tech4movies.shared.FilmesDTO;

@Service
public class FilmesServiceImpl implements FilmesService{

    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private FilmesRepository repository;

    
    @Override
    public List<FilmesDTO> obterFilmes() {
        List<Filmes> filmes = repository.findAll();

        return filmes.stream()
        .map(f -> mapper.map(f, FilmesDTO.class))
        .collect(Collectors.toList());
    }
    
    @Override
    public Optional<FilmesDTO> obterFilmesPorId(String id) {
        Optional<Filmes> filmes = repository.findById(id);

        if (filmes.isPresent()) {
            return Optional.of(mapper.map(filmes.get(), FilmesDTO.class));
        }
        return Optional.empty();
    }
    
    @Override
    public FilmesDTO cadastrarFilmes(FilmesDTO filmes) {
        Filmes filme = mapper.map(filmes, Filmes.class);
        filme = repository.save(filme);
        return mapper.map(filme, FilmesDTO.class);
    }
    
    @Override
    public FilmesDTO atualizarFilmes(String id, FilmesDTO filmes) {
        Filmes filme = mapper.map(filmes, Filmes.class);
        filme.setId(id);
        filme = repository.save(filme);
        return mapper.map(filme, FilmesDTO.class);
    }

    @Override
    public void deletarFilme(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<FilmesDTO> obterFilmesPorDiretor(String diretor) {
        List<Filmes> filmes = repository.findByDiretor(diretor);

        return filmes.stream()
        .map(f -> mapper.map(f, FilmesDTO.class))
        .collect(Collectors.toList());
            
    }

    
}
