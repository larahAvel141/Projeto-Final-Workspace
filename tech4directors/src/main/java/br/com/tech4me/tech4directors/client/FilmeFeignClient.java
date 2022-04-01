package br.com.tech4me.tech4directors.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.tech4directors.shared.Filmes;

@FeignClient(name = "tech4movies", fallback = FilmesFeignClientFallback.class)
public interface FilmeFeignClient {
    @GetMapping(path = "/api/filmes/lista/{diretor}")
    List<Filmes> obterFilmesPorDiretor(@PathVariable String diretor);

}

@Component
class FilmesFeignClientFallback implements FilmeFeignClient{

    @Override
    public List<Filmes> obterFilmesPorDiretor(String diretor) {
        return new ArrayList<>();
    }

}
