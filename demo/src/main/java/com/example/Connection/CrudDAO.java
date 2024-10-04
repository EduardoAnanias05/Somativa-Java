package com.example.Connection;

import java.sql.Connection;
import java.util.List;

public abstract class CrudDAO <Modelo>{
    private Connection con;


     // Construtor vazio
     public CrudDAO() {
        // Pode permanecer vazio ou com alguma inicialização padrão, se necessário
    }

    // Construtor para inicializar conexão
    public CrudDAO(Connection con) {
        this.con = con;
    }

     public abstract void criarTabela();
    
    public abstract Modelo procurarPorId(String id);

    public abstract List<Modelo> listarTodos();

    public abstract void cadastrar(Modelo entidade);

    public abstract void atualizar(Modelo entidade);

    public abstract void deletar(String id);   

}