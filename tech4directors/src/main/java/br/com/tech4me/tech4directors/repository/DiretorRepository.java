package br.com.tech4me.tech4directors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4directors.model.Diretor;

public interface DiretorRepository extends MongoRepository<Diretor , String>{
    
}
