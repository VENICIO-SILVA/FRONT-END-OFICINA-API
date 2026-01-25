/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Login;

import com.oficina.project.service.LoginService;
import com.oficina.project.view.Login.LoginView;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class LoginController {

    private final LoginView view;
    private final LoginService service;

    public LoginController(LoginView view) {
        this.view = view;
        this.service = new LoginService();
        initController();
        System.out.println("CONTROLLER INICIADO");
    }

    private void initController() {
        //ação do botao que leva ao metodo login da classe service
        view.getBtLogin().addActionListener(e -> login());
    }

    private void login() {
        //captura os dados dos campos da tela
        String email = view.getEmail().trim();
        String senha = view.getSenha().trim();
        System.out.println("LOGIN ACIONADO");

        //verifica se os campos estao preenchidos
        if (email.isBlank() || senha.isBlank()) {
            JOptionPane.showMessageDialog(null, "Preencha email e senha", "validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean sucesso = service.login(email, senha);

        if (sucesso) {
            JOptionPane.showMessageDialog(view,
                    "Login realizado com sucesso");
            view.dispose();
            TelaPrincipal iniciar = new TelaPrincipal();
            iniciar.MenuUsuarios.setEnabled(true);
            iniciar.setVisible(true);
            // fecha tela de login
            // abrir tela principal depois
        } else {
            JOptionPane.showMessageDialog(view,
                    "Email ou senha inválidos",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
