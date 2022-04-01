package br.com.tech4me.tech4directors.shared;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class DiretorDTO {
    
    private String id;
    @NotBlank(message = "Informe o nome do(a) diretor(a)")
    private String nome;
    @NotBlank(message = "Informe a nacionalidade do(a) diretor(a)")
    private String nacionalidade;
    @NotBlank(message = "Informe o genêro do(a) diretor(a) --- Ex: feminino/masculino ou outros(suspense, ação, romance ...)")
    private String genero;
    @Positive
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
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getPremios() {
        return premios;
    }
    public void setPremios(int premios) {
        this.premios = premios;
    }
}
