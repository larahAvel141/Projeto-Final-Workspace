package br.com.tech4me.tech4movies.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4movies.service.FilmesService;
import br.com.tech4me.tech4movies.shared.FilmesDTO;
import br.com.tech4me.tech4movies.view.model.FilmesRequestDTO;
import br.com.tech4me.tech4movies.view.model.FilmesResponseDTO;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private FilmesService service;

    @GetMapping
    public ResponseEntity<List<FilmesResponseDTO>> obterFilmes(){
        List<FilmesDTO> filme = service.obterFilmes();

        List<FilmesResponseDTO> movies = filme.stream()
        .map(f -> mapper.map(f, FilmesResponseDTO.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FilmesResponseDTO> obterFilmesPorId(@PathVariable String id) {
        Optional<FilmesDTO> filme = service.obterFilmesPorId(id);
        
        if (filme.isPresent()) {
            return new ResponseEntity<>(mapper.map(filme.get(), FilmesResponseDTO.class)
            ,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "/status")
    public String status(@Value ("${local.server.port}")String status) {
        return "Está rodando na porta: " + status;
    }

    @GetMapping("/lista/{diretor}")
    public ResponseEntity<List<FilmesRequestDTO>> filmesPorDiretor(@PathVariable String diretor) {
        List<FilmesDTO> dto = service.obterFilmesPorDiretor(diretor);

        List<FilmesRequestDTO> filmes = dto.stream()
        .map(f -> mapper.map(f, FilmesRequestDTO.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(filmes,HttpStatus.OK);

        
        
    }

    @PostMapping
    public ResponseEntity<FilmesDTO> cadastarFilmes(@RequestBody @Valid FilmesDTO filmes) {
        return new ResponseEntity<>(service.cadastrarFilmes(filmes),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmesDTO> atualizarFilmesPorId(@PathVariable String id, @RequestBody @Valid FilmesDTO filmes) {
        return new ResponseEntity<>(service.atualizarFilmes(id,filmes),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilmesPorId(@PathVariable String id) {
        service.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    
}
