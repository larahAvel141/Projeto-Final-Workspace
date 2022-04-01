package br.com.tech4me.tech4directors.view.model;

import java.util.List;

import br.com.tech4me.tech4directors.shared.Filmes;

public class DiretorResponseDTO {
    private String id;
    private String nome;
    private String nacionalidade;
    private int premios;

    private List<Filmes> filmes;
    
    public String getId() {
        return id;
    }
    public List<Filmes> getFilmes() {
        return filmes;
    }
    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPremios() {
        return premios;
    }
    public void setPremios(int premios) {
        this.premios = premios;
    }
}
