/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Administradores;

import com.oficina.project.service.AdministradoresService;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class CadastrarAdmController {

    private TelaPrincipal view;
    private AdministradoresService service;

    public CadastrarAdmController(TelaPrincipal view) {
        this.view = view;
        this.service = new AdministradoresService();
        IniciarController();
        System.out.println("CONTROLLER INICIADO funcionario");

    }

    private void IniciarController() {

        view.getBtSalvarFuncionario().addActionListener(e -> CadastrarFuncionario());

    }

    private void CadastrarFuncionario() {
        String Nome = view.GetNomeFuncionario().trim();
        String Email = view.GetEmailFuncionario().trim();
        String Senha = view.GetSenhaFuncionario().trim();
        String Cargo = view.GetCargoFuncionario().trim();
        String Telefone = view.GetTelefoneFuncionario().trim();
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

        boolean sucesso = service.CadastrarADM(Nome, Email, Senha, Cargo, Telefone);
        view.AtivarBarraProgressoFuncionario().setValue(100);
        Timestamp agora = new Timestamp(System.currentTimeMillis());

        view.RetornoDadosFuncionario(Nome, Email, Senha, Telefone, Cargo, agora.toString());
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
    }
}
