package com.example.Model;

public class Maquina {
    private String codigo;
    private String nome;
    private String marca;
    private String descricao;
    private String dataAquisicao;
    private boolean emManutencao;


    public Maquina(String codigo, String nome, String marca, String descricao, String dataAquisicao, boolean emManutencao) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.emManutencao = emManutencao;
    }

    public Maquina(){}

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    // Setter para 'emManutencao'
    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    public String getDataAquisicao(){
        return dataAquisicao;
    }
    

    
}
