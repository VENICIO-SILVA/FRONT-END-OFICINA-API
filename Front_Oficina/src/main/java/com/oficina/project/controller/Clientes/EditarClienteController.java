/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Clientes;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.oficina.project.service.ClienteService;
import com.oficina.project.view.TelaPrincipal.ClienteViews.CadastrarClienteView;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class EditarClienteController {
    private TelaPrincipal view;
    private ClienteService service;

    public EditarClienteController(TelaPrincipal view) {
        this.view = view;
        this.service = new ClienteService();
        System.out.println("Editar Cliente iniciado");
        IniciarController();
    }

    private void IniciarController() {
        System.out.println("Editar iniciado");
        view.getBtEditar().addActionListener(e -> Editar());
    }

    private void Editar() {
        System.out.println("Editar iniciado");
        // Recupera o Map com os dados da view
        Map<String, String> dados = view.InfoUsuarioEditar();
        String IdCliente = dados.get("id");
        String Nome = dados.get("Nome");
        String Email = dados.get("email");
        String Telefone = dados.get("telefone");
        String Endereco = dados.get("endereco");
        String Cpf = dados.get("cpf");
        
        
      

        boolean sucesso = service.EditarCliente(IdCliente, Nome, Email, Telefone, Endereco, Cpf);
        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "Usuario editado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel editar o Usuario");
        }
    }
    
}
