package com.example.Model;

public abstract class Usuario {
    private String cpf;
    private String senha;

    public Usuario(){}

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    
}
