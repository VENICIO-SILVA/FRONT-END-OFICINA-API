/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Clientes;

import com.oficina.project.service.CarrosService;
import com.oficina.project.service.ClienteService;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class ExcluirClienteController {

    private TelaPrincipal view;
    private ClienteService service;

    public ExcluirClienteController(TelaPrincipal view) {
        this.view = view;
        this.service = new ClienteService();
        IniciarController();

    }

    private void IniciarController() {
        //Reconhe o o metodo GET que recebe click no botao excluir do front 
        //em seguida chama o metodo "ExcluirUsuario" atraves do click
        view.getBtExcluirCliente().addActionListener(e -> ExcluirCliente());

    }

    private void ExcluirCliente() {
        //Estudar melhor op metodo e otimizar o service
        String IdCliente = view.GetIdUsuarioCliente().trim();
        boolean sucesso = service.ExcluirCliente(IdCliente);
        if (sucesso == false) {
            JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel Excluir o Cliente");
        }

    }
}
