package com.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import com.example.Connection.MaquinaDAO;
import com.example.Controller.MaquinasController;
import com.example.Model.Maquina;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ListMaq extends JPanel {

    private JTable tabelaMaquinas;
    private DefaultTableModel tableModel;
    private MaquinasController maquinasController;
    private JButton btnExcluir, btnAtualizar, btnManutencao;

    public ListMaq() {
        // Define o layout da tela
        setLayout(new BorderLayout());

        // Inicializa o controlador
        maquinasController = new MaquinasController();

        // Cria o modelo da tabela
        tableModel = new DefaultTableModel(
                new Object[] { "Código", "Nome", "Marca", "Descrição", "Data de Aquisição", "Em Manutenção" }, 0);
        tabelaMaquinas = new JTable(tableModel);

        // Passa a tabela para o controlador
        maquinasController.setTable(tabelaMaquinas); 



        // Adiciona a tabela dentro de um JScrollPane
        add(new JScrollPane(tabelaMaquinas), BorderLayout.CENTER);

        // Painel de botões na parte inferior
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Botões de excluir e atualizar
        btnExcluir = new JButton("Excluir Máquina");
        btnAtualizar = new JButton("Atualizar Máquina"); 
        JButton btnManutencao = new JButton("Colocar em Manutenção");panelBotoes.add(btnManutencao);

    btnManutencao.addActionListener(e->

    colocarEmManutencao());

        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnAtualizar);

        // Adiciona o painel de botões à tela
        add(panelBotoes, BorderLayout.SOUTH);

        // Atualiza a tabela com os dados das máquinas
        atualizarTabela();

        // Ação do botão Excluir
        btnExcluir.addActionListener(e -> excluirMaquina());

        // Ação do botão Atualizar
        btnAtualizar.addActionListener(e -> atualizarMaquina());
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        List<Maquina> maquinas = maquinasController.listarTodos(); // Pega a lista de máquinas

        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[] {
                    maquina.getCodigo(),
                    maquina.getNome(),
                    maquina.getMarca(),
                    maquina.getDescricao(),
                    maquina.getDataAquisicao(),
                    maquina.isEmManutencao()
                    
            });
        }
    }

    private void excluirMaquina() {
        int selectedRow = tabelaMaquinas.getSelectedRow();
        if (selectedRow != -1) {
            String codigo = tableModel.getValueAt(selectedRow, 0).toString();
            maquinasController.deletar(codigo); // Exclui a máquina com o código selecionado
            atualizarTabela(); // Atualiza a tabela
            JOptionPane.showMessageDialog(this, "Máquina excluída com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para excluir.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarMaquina() {
        int selectedRow = tabelaMaquinas.getSelectedRow();
        if (selectedRow != -1) {
            String codigo = tableModel.getValueAt(selectedRow, 0).toString();
            String nome = tableModel.getValueAt(selectedRow, 1).toString();
            String marca = tableModel.getValueAt(selectedRow, 2).toString();
            String descricao = tableModel.getValueAt(selectedRow, 3).toString();
            String dataAquisicao = tableModel.getValueAt(selectedRow, 4).toString();
            boolean emManutencao = (boolean) tableModel.getValueAt(selectedRow, 5);

            // Chama o método do controlador para atualizar a máquina
            maquinasController.editar(codigo, nome, marca, descricao, dataAquisicao, emManutencao);
            atualizarTabela(); // Atualiza a tabela
            JOptionPane.showMessageDialog(this, "Máquina atualizada com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para atualizar.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    
private void colocarEmManutencao() {
    int selectedRow = tabelaMaquinas.getSelectedRow();
    if (selectedRow != -1) {
        String codigo = tableModel.getValueAt(selectedRow, 0).toString();
        maquinasController.marcarManutencao(codigo, true); // Marca a máquina como em manutenção
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Máquina marcada como em manutenção!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione uma máquina para marcar como em manutenção.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
public void marcarManutencao(String codigo, boolean emManutencao) {
    MaquinaDAO maquinaDAO = new MaquinaDAO();
    Maquina maquina = maquinaDAO.procurarPorId(codigo); // Altere o método para buscar pela ID
    if (maquina != null) {
        maquina.setEmManutencao(emManutencao); // Atualiza o estado
        maquinaDAO.atualizar(maquina); // Atualiza no banco de dados
    }
} 

 
}



