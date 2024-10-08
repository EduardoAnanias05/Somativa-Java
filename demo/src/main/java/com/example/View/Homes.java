package com.example.View;

import java.awt.Toolkit;
import com.example.Controller.LoginController;
import javax.swing.JOptionPane;

public class Homes extends javax.swing.JFrame {

    public Homes() {
        super("Home");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        inputSenha = new javax.swing.JPasswordField();
        inputCpf = new javax.swing.JFormattedTextField();
        btnEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel(); 
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();


        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(830, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(830, 600));
        getContentPane().setLayout(null);
        getContentPane().add(inputSenha);
        jLabel2.setText("Nome:");
        inputSenha.setBounds(480, 310, 170, 30);
        getContentPane().add(inputCpf);
        jLabel3.setText("Senha:");
        inputCpf.setBounds(480, 240, 170, 30);

        btnEntrar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(520, 360, 130, 27);
    


        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bem vindo ao sistema de gerenciamento de maquinas");
        getContentPane().add(jLabel1); 
        getContentPane().add(jLabel2); 
        getContentPane().add(jLabel3); 




        jLabel1.setBounds(0, 0, 830, 550); 
        jLabel2.setBounds(480, 210, 170, 30);
        jLabel3.setBounds(480, 270, 170, 30);

        pack();


        btnEntrar.addActionListener(e -> {
            LoginController operacao = new LoginController();
            String usuario = inputCpf.getText();
            String senha = new String(inputSenha.getPassword());

            boolean loginRealizado = false;
          

            operacao.verificaLogin(usuario, senha, "supervisor");

            if (operacao.isSupervisor()) {
                new JanelaSupervisor().setVisible(true);
                loginRealizado = true;
            }

            if (!loginRealizado) {
                operacao.verificaLogin(usuario, senha, "tecnico");

                if (operacao.isTecnico()) {
                    new JanelaTecnico().setVisible(true);
                    loginRealizado = true;
                }
            }

            if (!loginRealizado) {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Erro de Login", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Homes().setVisible(true));
    }

    private javax.swing.JButton btnEntrar;
    private javax.swing.JFormattedTextField inputCpf;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
}