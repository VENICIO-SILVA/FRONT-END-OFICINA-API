/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Carros;

import com.oficina.project.service.CarrosService;
import com.oficina.project.view.TelaPrincipal.CarrosView.CadastrarCarrosView;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class CadastrarCarrosController {
     private CadastrarCarrosView view;
    private CarrosService service;

    public CadastrarCarrosController(CadastrarCarrosView view) {
        this.view = view;
        this.service = new CarrosService();
        IniciarController();
        System.out.println("CONTROLLER Carros INICIADO");

    }

    private void IniciarController() {

        view.getBtSalvar().addActionListener(e -> Cadastrar());

    }

    private void Cadastrar() {
        
        String idCliente = view.GetIdcarro().trim();
        String Modelo = view.GetModelo().trim();
        String Marca = view.GetMarca().trim();
        String Placa = view.GetPlaca().trim();
        String Cor = view.GetCor().trim();
        String Ano = view.GetAnoCarro().trim();
        System.out.println("Cadastrar carro ACIONADO");

       
        if (Modelo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar o Modelo do Veiculo");
            return;
        }
        if (Marca.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar a Marca do Veiculo");
            return;
        }
        if (Placa.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar a Placa do Veiculo");
            return;
        }
        if (Cor.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar a Cor do Veiculo");
            return;
        } if (Ano.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor Informar o Ano do Veiculo");
            return;
        }

        boolean sucesso = service.Cadastrar(idCliente, Modelo, Marca, Placa, Cor, Ano);
        view.AtivarBarraProgresso().setValue(100);
        Timestamp agora = new Timestamp(System.currentTimeMillis());
        
        view.RetornoDados(idCliente, Modelo, Marca, Placa, Cor, Ano, agora.toString());
        JOptionPane.showMessageDialog(null, "Carro Cadastrado com sucesso!");
    }
}
