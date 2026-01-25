/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.main;

import com.oficina.project.controller.Login.LoginController;
import com.oficina.project.view.Login.LoginView;

/**
 *
 * @author Venicio
 */
public class Main {
     public static void main(String[] args) {
        LoginView view = new LoginView();
        new LoginController(view);
        view.setVisible(true);
    }
    
}
