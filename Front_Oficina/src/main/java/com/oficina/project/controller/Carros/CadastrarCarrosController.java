package com.oficina.project.controller.Carros;

import com.oficina.project.service.CarrosService;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class CadastrarCarrosController {

    private TelaPrincipal view;
    private CarrosService service;

    public CadastrarCarrosController(TelaPrincipal view) {
        this.view = view;
        this.service = new CarrosService();
        IniciarController();
        System.out.println("CONTROLLER Carros INICIADO");
    }

    private void IniciarController() {
        view.getBtSalvarCarro().addActionListener(e -> Cadastrar());
    }

    private void Cadastrar() {

        System.out.println("Cadastrar carro ACIONADO");

        // 🔹 Pegando valores SEM trim()
        String idCliente = view.GetIdClienteCarroVinculado();
        String modelo = view.GetModeloCarro();
        String marca = view.GetMarca();
        String placa = view.GetPlaca();
        String cor = view.GetCor();
        String anoTexto = view.GetAnoCarro();

        // 🔹 Validação Cliente
        if (idCliente == null || idCliente.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Vincule um cliente antes de cadastrar o carro");
            return;
        }
        idCliente = idCliente.trim();

        // 🔹 Validação Modelo
        if (modelo == null || modelo.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor informar o modelo do veículo");
            return;
        }
        modelo = modelo.trim();

        // 🔹 Validação Marca
        if (marca == null || marca.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor informar a marca do veículo");
            return;
        }
        marca = marca.trim();

        // 🔹 Validação Placa
        if (placa == null || placa.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor informar a placa do veículo");
            return;
        }
        placa = placa.trim();

        // 🔹 Validação Cor
        if (cor == null || cor.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor informar a cor do veículo");
            return;
        }
        cor = cor.trim();

        // 🔹 Validação Ano
        if (anoTexto == null || anoTexto.isBlank()) {
            JOptionPane.showMessageDialog(null, 
                "Por favor informar o ano do veículo");
            return;
        }

        int anoConvertido;

        try {
            anoConvertido = Integer.parseInt(anoTexto.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "O ano deve ser um número inteiro válido");
            return;
        }

        if (anoConvertido < 1900 || anoConvertido > 2100) {
            JOptionPane.showMessageDialog(null, 
                "Informe um ano válido");
            return;
        }

        // 🔹 Chamada do Service (agora passando int corretamente)
        boolean sucesso = service.CadastrarCarro(
                idCliente, modelo, marca, placa, cor, anoTexto);

        if (!sucesso) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao cadastrar carro no banco de dados");
            return;
        }

        // 🔹 Atualizações visuais
        view.AtivarBarraProgressoCarro();
        Timestamp agora = new Timestamp(System.currentTimeMillis());

        view.RetornoDadosCarros(
                idCliente, modelo, marca, placa, cor, 
                String.valueOf(anoConvertido), 
                agora.toString()
        );

        JOptionPane.showMessageDialog(null, 
                "Carro cadastrado com sucesso!");
    }
}
