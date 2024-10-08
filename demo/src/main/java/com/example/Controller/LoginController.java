package com.example.Controller;

import javax.swing.JOptionPane;

import com.example.Connection.LoginDAO;
import com.example.Connection.MaquinaDAO;
import com.example.View.Homes;
import com.example.View.JanelaSupervisor;
import com.example.View.JanelaTecnico;


public class LoginController {
    private Homes loginView;
    private boolean isSupervisor;
    private boolean isTecnico;

    public LoginController(Homes loginView){
        this.loginView = loginView;
    }

    public LoginController(){super();}  


    public void verificaLogin(String usuario, String senha, String tipoUsuario){
        LoginDAO login = new LoginDAO();

        if (usuario == null || "".equals(usuario) || senha == null || "".equals(senha)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os dados corretamente!", "",
                    JOptionPane.WARNING_MESSAGE);
        }else {
         boolean loginValido = login.verificarLogin(usuario, senha, tipoUsuario);

         if(loginValido){
            if(tipoUsuario.equals("supervisor")){
                isSupervisor = true;
                new JanelaSupervisor();
            }else if(tipoUsuario.equals("tecnico")){
                isTecnico = true;
                new JanelaTecnico();
            }
         }else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "", JOptionPane.WARNING_MESSAGE);
         }
        }
    }

    public void iniciar(){
        LoginDAO init = new LoginDAO();
        init.criaTabela();
        init.inicializarBanco();
        Homes loginView = new Homes();
        LoginController loginController = new LoginController(loginView);
        MaquinaDAO ini = new MaquinaDAO();
        ini.criarTabela();
    }

    public boolean isSupervisor(){
        return isSupervisor;
    }

    public boolean isTecnico(){
        return isTecnico;   
    }
}
