package com.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaSupervisor extends JFrame {
    private JTabbedPane jTPane;
    private JMenuBar menuBar;
    private JPopupMenu popupMenu;

    public JanelaSupervisor() {
        super("Dashboard Supervisor");

        // Configurações básicas da janela
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Define o layout da janela explicitamente
        setLayout(new BorderLayout());

        // Inicializa o JTabbedPane
        jTPane = new JTabbedPane();

        // Inicializa o menu da barra de navegação
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navegação");

        // Opções do menu da barra
        JMenuItem menuCadastroMaquinas = new JMenuItem("Cadastro de Máquinas"); 
        JMenuItem menuListMaquinas = new JMenuItem("Lista de Maquinas");

        JMenuItem menuSair = new JMenuItem("Sair");

        // Adiciona as opções ao menu da barra
        menu.add(menuCadastroMaquinas); 
        menu.addSeparator(); // Separador visual 
        menu.add(menuListMaquinas); 
        menu.addSeparator(); // Separador visual
        menu.add(menuSair);
        menuBar.add(menu);

        // Define o menu na janela
        setJMenuBar(menuBar);

        // Adiciona o JTabbedPane na área central da janela
        add(jTPane, BorderLayout.CENTER);

        // Ação ao clicar em "Cadastro de Máquinas"
        menuCadastroMaquinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroMaquinas();
            }
        });

        // Ação ao clicar em "Lista de Máquinas"
        menuListMaquinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListaMaquinas();
            }
        });

        // Ação ao clicar em "Sair"
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha o programa
                }
            }
        });

        // Adiciona um menu popup (flutuante)
        popupMenu = new JPopupMenu();
        JMenuItem popupCadastroMaquinas = new JMenuItem("Cadastro de Máquinas (Popup)"); 
        JMenuItem popupListMaquinas = new JMenuItem("Lista de Maquinas (Popup)");
        
        JMenuItem popupSair = new JMenuItem("Sair (Popup)");

        popupMenu.add(popupCadastroMaquinas); 
        popupMenu.addSeparator();
        popupMenu.add(popupListMaquinas);
        popupMenu.addSeparator(); // Separador visual
        popupMenu.add(popupSair);

        // Ação ao clicar em "Cadastro de Máquinas" no popup
        popupCadastroMaquinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroMaquinas();
            }
        }); 

           // Ação ao clicar em "Lista de Máquinas" no popup
           popupListMaquinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListaMaquinas();
            }
        });

        // Ação ao clicar em "Sair" no popup
        popupSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha o programa
                }
            }
        });

        // Adiciona o comportamento do botão direito para mostrar o popup
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Tornar a janela visível após adicionar todos os componentes
        setVisible(true);
    }

    // Método para abrir a aba de cadastro de máquinas
    private void abrirCadastroMaquinas() {
        // Cria a tela de cadastro de máquinas
        CadMaq tab1 = new CadMaq(); // Nova instância da tela
        jTPane.add("Cadastro de Máquinas", tab1); // Adiciona ao JTabbedPane
    } 

      // Método para abrir a aba de cadastro de máquinas
      private void abrirListaMaquinas() {
        // Cria a tela de cadastro de máquinas
        ListMaq tab1 = new ListMaq(); // Nova instância da tela
        jTPane.add("Lista de Maquinas", tab1); // Adiciona ao JTabbedPane
    }


    public static void main(String[] args) {
        // Inicializa a janela principal
        new JanelaSupervisor();
    }
}
