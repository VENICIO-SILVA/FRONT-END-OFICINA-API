/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Administradores;

import com.oficina.project.service.AdministradoresService;
import com.oficina.project.view.TelaPrincipal.AdmViews.CadastrarAdmView;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.tools.Diagnostic;

/**
 *
 * @author Venicio
 */
public class EditarAdmController {

    private CadastrarAdmView view;
    private AdministradoresService service;

    public EditarAdmController(CadastrarAdmView view) {
        this.view = view;
        this.service = new AdministradoresService();
        System.out.println("Editar iniciado");
        IniciarController();
    }

    private void IniciarController() {
        System.out.println("Editar iniciado");
        view.getBtEditar().addActionListener(e -> Editar());
    }

    private void Editar() {
        System.out.println("Editar iniciado");
        // Recupera o Map com os dados da view
        Map<String, String> dados = view.InfouUsuarioComDados();
        String IdUsuario = dados.get("id");
        String Nome = dados.get("nome");
        String Email = dados.get("email");
        String Senha = dados.get("senha");
        String Telefone = dados.get("telefone");
        String Cargo = dados.get("cargo");

        boolean sucesso = service.EditarUsuario(IdUsuario, Nome, Email, Senha, Cargo, Telefone);
        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "Usuario editado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel editar o Usuario");
        }
    }

}
