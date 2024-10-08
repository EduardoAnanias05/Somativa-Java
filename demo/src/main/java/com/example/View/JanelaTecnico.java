package com.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import com.example.Controller.MaquinasController;
import com.example.Model.Maquina;

public class JanelaTecnico extends JFrame {
    private JTabbedPane jTPane;
    private JTable tabelaMaquinas;
    private DefaultTableModel tableModel;
    private MaquinasController maquinasController;
    private JButton btnDesmarcarManutencao;

    public JanelaTecnico() {
        super("Dashboard Técnico");
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa o controlador
        maquinasController = new MaquinasController();

        // Cria o JTabbedPane
        jTPane = new JTabbedPane();
        add(jTPane);

        // Painel de lista de máquinas em manutenção
        JPanel panelListaManutencao = new JPanel(new BorderLayout());
        
        // Tabela para exibir as máquinas
        tableModel = new DefaultTableModel(new Object[]{"Código", "Nome", "Marca", "Descrição", "Data de Aquisição", "Em Manutenção"}, 0);
        tabelaMaquinas = new JTable(tableModel);

        // Adiciona a tabela dentro de um JScrollPane
        panelListaManutencao.add(new JScrollPane(tabelaMaquinas), BorderLayout.CENTER);

        // Painel de botões
        JPanel panelBotoes = new JPanel();
        btnDesmarcarManutencao = new JButton("Concluir Manutenção");
        panelBotoes.add(btnDesmarcarManutencao);
        panelListaManutencao.add(panelBotoes, BorderLayout.SOUTH);

        // Adiciona o painel ao tabbed pane
        jTPane.addTab("Máquinas em Manutenção", panelListaManutencao);

        // Atualiza a tabela com as máquinas em manutenção
        atualizarTabelaManutencao();

        // Ação do botão Desmarcar Manutenção
        btnDesmarcarManutencao.addActionListener(e -> desmarcarManutencao());

        // Listener para mudanças nas abas
        jTPane.addChangeListener(e -> {
            if (jTPane.getSelectedIndex() == 0) {
                atualizarTabelaManutencao(); // Atualiza a lista sempre que a aba for acessada
            }
        });
    }

    private void atualizarTabelaManutencao() {
        tableModel.setRowCount(0); // Limpa a tabela
        List<Maquina> maquinasEmManutencao = maquinasController.listarEmManutencao(); // Pega a lista de máquinas em manutenção
        for (Maquina maquina : maquinasEmManutencao) {
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

    private void desmarcarManutencao() {
        int selectedRow = tabelaMaquinas.getSelectedRow();
        if (selectedRow != -1) {
            String codigo = tableModel.getValueAt(selectedRow, 0).toString();
            maquinasController.marcarManutencao(codigo, false); // Desmarca a manutenção
            atualizarTabelaManutencao(); // Atualiza a tabela após a ação
            JOptionPane.showMessageDialog(this, "Manutenção Concluida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para Concluir a manutenção.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaTecnico janelaTecnico = new JanelaTecnico();
            janelaTecnico.setVisible(true);
        });
    }
}
