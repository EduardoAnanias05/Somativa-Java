package com.example.View;

import javax.swing.*;
import java.awt.*;
import com.example.Controller.MaquinasController;

public class CadMaq extends JPanel {
    private JTextField fieldNome;
    private JTextField fieldModelo;
    private JTextField fieldFabricante;
    private JTextField fieldAno;
    private MaquinasController maquinasController;

    public CadMaq() {
        // Define o layout da tela
        setLayout(new GridLayout(5, 2, 10, 10)); // Exemplo de grid layout para organizar os componentes

        // Inicializa o controlador
        maquinasController = new MaquinasController();

        // Labels e campos de texto para os dados de cadastro de máquinas
        JLabel labelNome = new JLabel("Nome da Máquina:");
        fieldNome = new JTextField();

        JLabel labelModelo = new JLabel("Modelo:");
        fieldModelo = new JTextField();

        JLabel labelFabricante = new JLabel("Fabricante:");
        fieldFabricante = new JTextField();

        JLabel labelAno = new JLabel("Ano de Fabricação:");
        fieldAno = new JTextField();

        // Botão de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");

        // Adiciona os componentes ao painel
        add(labelNome);
        add(fieldNome);

        add(labelModelo);
        add(fieldModelo);

        add(labelFabricante);
        add(fieldFabricante);

        add(labelAno);
        add(fieldAno);

        // Espaço vazio antes do botão
        add(new JLabel()); // Um "espaçador" para alinhar o botão na última coluna

        // Adiciona o botão de cadastro
        add(btnCadastrar);

        // Adiciona a ação para o botão de cadastro
        btnCadastrar.addActionListener(e -> cadastrarMaquina());
    }

    private void cadastrarMaquina() {
        String nome = fieldNome.getText();
        String modelo = fieldModelo.getText();
        String fabricante = fieldFabricante.getText();
        String ano = fieldAno.getText();
        
        // Você pode implementar uma lógica para gerar um código único para a máquina
        String codigo = String.valueOf(System.currentTimeMillis()); // Exemplo simples de código único
        boolean emManutencao = false; // Ou use um checkbox para capturar isso

        // Valida os dados antes de cadastrar
        if (maquinasController.validarDados(codigo, nome, modelo, fabricante, ano, emManutencao)) {
            maquinasController.cadastrar(codigo, nome, modelo, fabricante, ano, emManutencao);
            JOptionPane.showMessageDialog(this, "Máquina cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            clearFields(); // Limpa os campos após o cadastro
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        fieldNome.setText("");
        fieldModelo.setText("");
        fieldFabricante.setText("");
        fieldAno.setText("");
    }
}
