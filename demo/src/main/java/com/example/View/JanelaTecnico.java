package com.example.View;


import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class JanelaTecnico extends JFrame{
    private JTabbedPane jTPane;

    public JanelaTecnico(){
        super("Dashboard Técnico");
        setResizable(false);
        


        jTPane = new JTabbedPane();
        add(jTPane);



        //tela de cadasto de maquinaas tab1 = new tela();
        //jTPane.add("tab1", tab1);


        jTPane.addChangeListener(e -> {
           // tela
        });
    }
}
