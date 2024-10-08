package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.Model.Maquina;

public class MaquinaDAO extends CrudDAO<Maquina> {
    private Connection connection;
    private List<Maquina> maquinas;

    public MaquinaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
public void criarTabela() {
    String sql = "create table if not exists maquinas(codigo varchar(20) primary key, nome varchar(255), marca varchar(255), descricao varchar(255), dataAquisicao varchar(255), emManutencao boolean default false)";
    
    try (Connection conn = ConnectionFactory.getConnection(); 
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
        System.out.println("tabela criada com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao criar tabela: " + e.getMessage());
    }
    // Não fechar a conexão aqui, pois é obtida e fechada automaticamente dentro do try-with-resources
}

    @Override
    public List<Maquina> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        maquinas = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM maquinas");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Maquina maq = new Maquina(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("descricao"),
                        rs.getString("dataAquisicao"),
                        rs.getBoolean("emManutencao"));
                maquinas.add(maq);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return maquinas;
    }

    @Override
    public void cadastrar(Maquina entidade) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO maquinas(codigo, nome, marca, descricao, dataAquisicao, emManutencao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, entidade.getCodigo());
            stmt.setString(2, entidade.getNome());
            stmt.setString(3, entidade.getMarca());
            stmt.setString(4, entidade.getDescricao());
            stmt.setString(5, entidade.getDataAquisicao());
            stmt.setBoolean(6, entidade.isEmManutencao());
            stmt.executeUpdate();
            System.out.println("Máquina cadastrada com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    @Override
    public void atualizar(Maquina entidade) {
        String sql = "UPDATE maquinas SET nome = ?, marca = ?, descricao = ?, dataAquisicao = ?, emManutencao = ? WHERE codigo = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getMarca());
            stmt.setString(3, entidade.getDescricao());
            stmt.setString(4, entidade.getDataAquisicao());
            stmt.setBoolean(5, entidade.isEmManutencao());
            stmt.setString(6, entidade.getCodigo());
            stmt.executeUpdate();
            System.out.println("Máquina atualizada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados: " + e.getMessage());
        }
    }
    

    @Override
    public void deletar(String codigo) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM maquinas WHERE codigo = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            System.out.println("Máquina excluída com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro na exclusão da máquina: " + e.getMessage() + e.getSQLState());
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    @Override
    public Maquina procurarPorId(String id) {
        return buscarPorCodigo(id);
    }

    public List<Maquina> listarEmManutencao() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maquina> maquinasEmManutencao = new ArrayList<>();

        String sql = "SELECT * FROM maquinas WHERE emManutencao = true";

        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Maquina maq = new Maquina(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("descricao"),
                        rs.getString("dataAquisicao"),
                        rs.getBoolean("emManutencao"));
                maquinasEmManutencao.add(maq);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar máquinas em manutenção: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return maquinasEmManutencao; // Retorna a lista de máquinas em manutenção
    }

    public Maquina buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM maquinas WHERE codigo = ?";
        Maquina maquina = null;
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    maquina = new Maquina(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("descricao"),
                        rs.getString("dataAquisicao"),
                        rs.getBoolean("emManutencao")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar máquina: " + e.getMessage());
        }
        
        return maquina;
    }
    
}
