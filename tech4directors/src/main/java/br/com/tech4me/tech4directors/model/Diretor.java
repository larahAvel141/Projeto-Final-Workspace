package br.com.tech4me.tech4directors.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("diretores")
public class Diretor {
    @Id
    private String id;
    private String nome;
    private String nacionalidade;
    private String genero;
    private int premios;

    public String getId() {
        return id;
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
