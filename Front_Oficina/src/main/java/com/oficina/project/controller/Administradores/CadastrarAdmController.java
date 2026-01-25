/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Administradores;

import com.oficina.project.service.AdministradoresService;
import com.oficina.project.view.TelaPrincipal.AdmViews.CadastrarAdmView;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class CadastrarAdmController {

    private CadastrarAdmView view;
    private AdministradoresService service;

    public CadastrarAdmController(CadastrarAdmView view) {
        this.view = view;
        this.service = new AdministradoresService();
        IniciarController();
        System.out.println("CONTROLLER INICIADO");

    }

    private void IniciarController() {

        view.getBtSalvar().addActionListener(e -> Cadastrar());

    }

    private void Cadastrar() {
        String Nome = view.GetNome().trim();
        String Email = view.GetEmail().trim();
        String Senha = view.GetSenha().trim();
        String Cargo = view.GetCargo().trim();
        String Telefone = view.GetTelefone().trim();
        System.out.println("Cadastrar ACIONADO");

        if (Nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um nome");
            return;
        }
        if (Email.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um Email");
            return;
        }
        if (Senha.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar uma Senha");
            return;
        }
        if (Cargo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar O Cargo");
            return;
        }
        if (Telefone.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um Telefone");
            return;
        }

        boolean sucesso = service.Cadastrar(Nome, Email, Senha, Cargo, Telefone);
        view.AtivarBarraProgresso().setValue(100);
        Timestamp agora = new Timestamp(System.currentTimeMillis());
        
        view.RetornoDadosADM(Nome, Email, Senha, Telefone, Cargo, agora.toString());
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
    }
}
