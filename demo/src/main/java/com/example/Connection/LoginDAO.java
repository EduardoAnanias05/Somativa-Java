package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class LoginDAO {

    private Connection connection;

    public LoginDAO(){
        this.connection = ConnectionFactory.getConnection();
    }


    private boolean tabelaExiste(){
        boolean tabelaExiste = false;
        String verificaTabela = "SELECT 1 FROM login LIMIT 1";

        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(verificaTabela);
            tabelaExiste = true;
        }catch(SQLException e ){
          //imprimir msg e gerar erro
        }
        return tabelaExiste;
    }


    public void criaTabela(){
        String sql = "create table if not exists login (senha varchar(30), usuario varchar(25) primary key, senhatecnico varchar(30), usuariotecnico varchar(30) )";
        try (Statement stmt = this.connection.createStatement()){
            stmt.execute(sql);
    }catch(SQLException e){
        //imprimir erro
    }
}


    public void inicializarBanco(){
        try{
            if(!tabelaExiste()){
                criaTabela();
                preencherTabela("Supervisor", "adm", "tecnico", "tec");
            }
            preencherTabela("adm", "adm", "tecnico", "tecnico");
        }catch(Exception e ){
            //imprimir msg de erro aqui
        }
    }

    public void preencherTabela(String usuario, String senha, String usuarioTecnico, String senhatecnico){
        PreparedStatement stmt = null;
        String sql = "insert into login (usuario, senha, usuariotecnico, senhatecnico) values (?, ?, ?, ?)";
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setString(3, usuarioTecnico);
            stmt.setString(4, senhatecnico);
            stmt.executeUpdate();
            System.out.println("Credenciais criadas");
        }catch(SQLException e){
            throw new RuntimeException("Erro ao criar credenciais" +  e.getMessage());
        }
    }


    public boolean verificarLogin(String usuario, String senha, String tipoUsuario){
        PreparedStatement stmt = null;
        boolean loginValido = false;
        ResultSet resultado = null;
        String sql = "";
    
        if (tipoUsuario.equals("supervisor")) {
            sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        } else if (tipoUsuario.equals("tecnico")) {
            sql = "SELECT * FROM login WHERE usuariotecnico = ? AND senhatecnico = ?";
        } 
    
        try {
            // Prepara a consulta SQL com os parâmetros de usuário e senha correspondentes ao tipo de usuário
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            resultado = stmt.executeQuery();
    
            // Verifica se a consulta retornou algum resultado válido
            if(resultado.next()){
                loginValido = true;
                if (tipoUsuario.equals("supervisor")) {
                  //imprimir msg
                } else if (tipoUsuario.equals("tecnico")) {
                     //imprimir msg
                } 
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar credenciais." + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return loginValido;
    }
}