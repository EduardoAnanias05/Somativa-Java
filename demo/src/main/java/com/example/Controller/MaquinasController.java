package com.example.Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.MaquinaDAO;
import com.example.Model.Maquina;

public class MaquinasController {

    private List<Maquina> maquinas;
    private DefaultTableModel tableModel;
    private JTable table;

    public MaquinasController() {
        super();
    }

      // Método para definir a JTable
      public void setTable(JTable table) {
        this.table = table;
    }
    public MaquinasController(List<Maquina> maquinas, DefaultTableModel tableModel, JTable table) {
        this.maquinas = maquinas;
        this.tableModel = tableModel;
        this.table = table;
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        maquinas = new MaquinaDAO().listarTodos();

        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[] {
                    maquina.getCodigo(),
                    maquina.getNome(),
                    maquina.getMarca(),
                    maquina.getDescricao(),
                    maquina.getDataAquisicao(),
                    maquina.isEmManutencao(),
            });
        }

    }

    // Método para listar todas as máquinas (sem a parte da tabela)
    public List<Maquina> listarTodos() {
        maquinas = new MaquinaDAO().listarTodos();
        return maquinas;
    } 

    
    

    public void cadastrar(String codigo, String nome, String marca, String descricao, String dataAquisicao,
            boolean emManutencao) {
        Maquina novaMaquina = new Maquina(codigo, nome, marca, descricao, dataAquisicao, emManutencao);
        new MaquinaDAO().cadastrar(novaMaquina);
        // imprimir msg aqui ou joption pane
        atualizarTabela();
    }

    public void editar(String codigo, String nome, String marca, String descricao, String dataAquisicao,
            boolean emManutencao) {
        Maquina maquina = new Maquina(codigo, nome, marca, descricao, dataAquisicao, emManutencao);
        new MaquinaDAO().atualizar(maquina);
        // imprimir msg aqui ou joption pane
        atualizarTabela();
    }

    public void deletar(String codigo) {
        Object[] opcoes = { "Sim", "Não" };
        int linhaSelecionada = (table != null) ? table.getSelectedRow() : -1;

        try {
            if (linhaSelecionada >= 0) {
                int resposta = JOptionPane.showOptionDialog(null,
                        "Deseja excluir a máquina? ",
                        "Excluir Máquina", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                if (resposta == JOptionPane.YES_OPTION) {
                    new MaquinaDAO().deletar(codigo);
                    // Atualiza a tabela de exibição após a exclusão
                    JOptionPane.showMessageDialog(null, "Máquina deletada com sucesso!"); 
                    atualizarTabela(); 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma máquina para excluir");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma máquina para excluir");
        }
    }

    public boolean validarDados(String codigo, String nome, String marca, String descricao, String dataAquisicao,
            boolean emManutencao) {
        boolean dadosValidos = true;

        if (codigo.isEmpty() || nome.isEmpty() || marca.isEmpty() || descricao.isEmpty() || dataAquisicao.isEmpty()) {
            dadosValidos = false;
        }

        return dadosValidos;
    } 

    public void marcarManutencao(String codigo, boolean emManutencao) {
        MaquinaDAO maquinaDAO = new MaquinaDAO(); // Cria apenas uma instância de MaquinaDAO
        Maquina maquina = maquinaDAO.buscarPorCodigo(codigo); // Busca a máquina pelo código
        
        if (maquina != null) {
            maquina.setEmManutencao(emManutencao); // Atualiza o estado da máquina
            maquinaDAO.atualizar(maquina); // Atualiza a máquina no banco de dados
            
            // Se a atualização foi bem-sucedida, atualiza a tabela
            atualizarTabela(); 
        } else {
            System.out.println("Máquina não encontrada: " + codigo);
        }
    }
    // Método para listar máquinas em manutenção
    public List<Maquina> listarEmManutencao() {
        return new MaquinaDAO().listarEmManutencao(); // Retorna a lista de máquinas em manutenção
    }
}
