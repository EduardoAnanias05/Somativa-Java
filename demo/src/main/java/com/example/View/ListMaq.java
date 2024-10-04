package com.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import com.example.Controller.MaquinasController;
import com.example.Model.Maquina;

public class ListMaq extends JPanel {
    private JTable tabelaMaquinas;
    private DefaultTableModel tableModel;
    private MaquinasController maquinasController;
    private JButton btnExcluir, btnAtualizar;

    public ListMaq() {
        // Define o layout da tela
        setLayout(new BorderLayout()); // Usa BorderLayout para permitir o uso de JScrollPane

        // Inicializa o controlador
        maquinasController = new MaquinasController();

        // Cria o modelo da tabela
        tableModel = new DefaultTableModel(new Object[]{"Código", "Nome", "Marca", "Descrição", "Data de Aquisição", "Em Manutenção"}, 0);
        tabelaMaquinas = new JTable(tableModel);

        // Adiciona a tabela dentro de um JScrollPane
        add(new JScrollPane(tabelaMaquinas), BorderLayout.CENTER);

        // Painel de botões na parte inferior
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Botões de excluir e atualizar
        btnExcluir = new JButton("Excluir Máquina");
        btnAtualizar = new JButton("Atualizar Máquina");

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
            tableModel.addRow(new Object[]{
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
            JOptionPane.showMessageDialog(this, "Máquina excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Máquina atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
