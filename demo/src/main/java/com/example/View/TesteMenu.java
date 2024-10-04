package com.example.View;

import javax.swing.*;

public class TesteMenu extends JFrame {
    public TesteMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TesteMenu();
    }
}
