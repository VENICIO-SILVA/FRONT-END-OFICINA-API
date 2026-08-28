/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.controller.Administradores;

import com.oficina.project.service.AdministradoresService;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Venicio
 */
public class ApagarAdmController {
    private TelaPrincipal view;
    private AdministradoresService service;
    
    public ApagarAdmController(TelaPrincipal view){
        this.view = view;
        this.service = new AdministradoresService();
        IniciarController();
        
    }
    
    private void IniciarController(){
        //Reconhe o o metodo GET que recebe click no botao excluir do front 
        //em seguida chama o metodo "ExcluirUsuario" atraves do click
        view.getBtSalvarFuncionario().addActionListener(e -> ExcluirUsuario());
        
    }
    
    private void ExcluirUsuario(){
        //Estudar melhor op metodo e otimizar o service
        String IdUsuario = view.GetIdFuncionario().trim();
        boolean sucesso = service.ApagarADM(IdUsuario);
        if(sucesso == false){
        JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel Excluir o Usuario");
        }
        
    }
}
