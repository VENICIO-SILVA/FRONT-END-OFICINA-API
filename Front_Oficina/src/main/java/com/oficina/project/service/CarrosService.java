/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Venicio
 */
public class CarrosService {

    public boolean CadastrarCarro(String idCliente, String modelo, String marca, String placa, String cor, String ano) {
        try {
            URL url = new URL("http://localhost:8080/Carros/Cadastrar/" + idCliente);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"id\":\"" + idCliente + "\","
                    + "\"modelo\":\"" + Modelo + "\","
                    + "\"email\":\"" + Marca + "\","
                    + "\"placa\":\"" + Placa + "\","
                    + "\"cor\":\"" + Cor + "\","
                    + "\"ano\":\"" + Ano + "\""
                    + "}".formatted(idCliente, Modelo, Marca, Placa, Cor, Ano);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
