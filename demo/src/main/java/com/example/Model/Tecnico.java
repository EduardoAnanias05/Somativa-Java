package com.example.Model;

public class Tecnico extends Usuario {
    private String nome;
    private String chefe_id;

    public Tecnico(){}

    public Tecnico(String nome, String chefe_id) {
        this.nome = nome;
        this.chefe_id = chefe_id;
    }
    public Tecnico(String cpf, String senha, String nome, String chefe_id) {
        super(cpf, senha);
        this.nome = nome;
        this.chefe_id = chefe_id;
    }

    public String getNome() {
        return nome;
    }

    public String getChefe_id() {
        return chefe_id;
    }

    
}
