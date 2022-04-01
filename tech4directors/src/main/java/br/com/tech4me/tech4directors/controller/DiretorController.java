package br.com.tech4me.tech4directors.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.tech4me.tech4directors.service.DiretorService;
import br.com.tech4me.tech4directors.shared.DiretorDTO;
import br.com.tech4me.tech4directors.view.model.DiretorResponseDTO;

@RestController
@RequestMapping("/api/diretores")
public class DiretorController {

    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private DiretorService service;

    @GetMapping
    public ResponseEntity<List<DiretorResponseDTO>> obterDiretores(){
        List<DiretorDTO> diretor = service.obterDiretores();

        List<DiretorResponseDTO> d = diretor.stream()
        .map(f -> mapper.map(f, DiretorResponseDTO.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorResponseDTO> obterDiretorPorId(@PathVariable String id) {
        Optional<DiretorDTO> diretor = service.obterDiretorPorId(id);

        if (diretor.isPresent()) {
            return new ResponseEntity<>(mapper.map(diretor.get(), DiretorResponseDTO.class)
            ,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DiretorDTO> cadastarDiretor(@RequestBody @Valid DiretorDTO diretor) {
        return new ResponseEntity<>(service.cadastrarDiretor(diretor),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiretorDTO> atualizarDiretorPorId(@PathVariable String id, @RequestBody @Valid DiretorDTO diretor) {
        return new ResponseEntity<>(service.atualizarDiretor(id,diretor),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretorPorId(@PathVariable String id) {
        service.deletarDiretor(id);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    
}
