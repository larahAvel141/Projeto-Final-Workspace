package br.com.tech4me.tech4movies.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4movies.shared.FilmesDTO;

public interface FilmesService {

    List<FilmesDTO> obterFilmes();

    Optional<FilmesDTO> obterFilmesPorId(String id);

    FilmesDTO cadastrarFilmes(FilmesDTO filmes);

    FilmesDTO atualizarFilmes(String id, FilmesDTO filmes);

    void deletarFilme(String id);

    List<FilmesDTO> obterFilmesPorDiretor(String diretor);
    
}
