package com.example.Model;

public class Supervisor extends Usuario {
    private String nome;


    public Supervisor(){}

    public Supervisor(String nome) {
        this.nome = nome;
       
    }
    public Supervisor(String cpf, String senha, String nome) {
        super(cpf, senha);
        this.nome = nome;
      
    }

    public String getNome() {
        return nome;
    }
    
}
