/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Clientes;

import com.oficina.project.service.ClienteService;
import com.oficina.project.view.TelaPrincipal.ClienteViews.CadastrarClienteView;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class CadastrarClienteController {

    private TelaPrincipal view;
    private ClienteService service;

    public CadastrarClienteController(TelaPrincipal view) {
        this.view = view;
        this.service = new ClienteService();
        IniciarController();
        System.out.println("CLIENTE CONTROLLER INICIADO");
    }

    private void IniciarController() {

        view.getBtSalvar().addActionListener(e -> Cadastrar());

    }

    private void Cadastrar() {
        String Nome = view.GetNome().trim();
        String Email = view.GetEmail().trim();
        String Cpf = view.GetCpf().trim();
        String Telefone = view.GetTelefone().trim();
        String Endereco = view.GetEndereco().trim();

        System.out.println("Cadastrar ACIONADO");

        if (Nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um nome");
            return;
        }
        if (Email.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um Email");
            return;
        }
        if (Telefone.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar uma Senha");
            return;
        }
        if (Endereco.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um Cargo");
            return;
        }
        if (Cpf.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar um CPF");
            return;
        }

        boolean sucesso = service.Cadastrar(Nome, Email, Telefone, Endereco, Cpf);
        view.AtivarBarraProgresso().setValue(100);
        Timestamp DataCadastro = new Timestamp(System.currentTimeMillis());

        view.RetornoDados(Nome, Email, Telefone, Endereco, Cpf, DataCadastro.toString());
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }
}
