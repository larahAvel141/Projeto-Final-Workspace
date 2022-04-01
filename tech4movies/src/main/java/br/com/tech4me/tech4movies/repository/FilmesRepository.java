package br.com.tech4me.tech4movies.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4movies.model.Filmes;

public interface FilmesRepository extends MongoRepository<Filmes, String>{

    List<Filmes> findByDiretor(String diretor);
    
}
