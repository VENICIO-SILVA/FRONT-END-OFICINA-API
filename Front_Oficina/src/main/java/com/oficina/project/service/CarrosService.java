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
                    + "\"modelo\":\"" + modelo + "\","
                    + "\"marca\":\"" + marca + "\","
                    + "\"placa\":\"" + placa + "\","
                    + "\"cor\":\"" + cor + "\","
                    + "\"ano\":\"" + ano + "\""
                    + "}";

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == HttpURLConnection.HTTP_OK;

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar carro: " + e);
            return false;
        }
    }

    public boolean ApagarCarros(String DTO) {
        try {
            //abertura de conexao
            URL url = new URL("http://localhost:8080/Carros/ApagarCarro/" + DTO);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"ID\":\"" + DTO + "\",".formatted(DTO);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
