/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oficina.project.model.entities.Clientes;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Venicio
 */
public class ClienteService {
    
    public boolean Cadastrar(String Nome, String Email, String Telefone, String Endereco, String cpf){
                try {
            URL url = new URL("http://localhost:8080/Cliente/Cadastrar");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"Nome\":\"" + Nome + "\","
                    + "\"email\":\"" + Email + "\","
                    + "\"telefone\":\"" + Telefone + "\","
                    + "\"endereco\":\"" + Endereco + "\","
                    + "\"cpf\":\"" + cpf + "\""
                    + "}".formatted(Nome, Email, cpf, Telefone, Endereco);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
      public List<Clientes> BuscarCliente(String DTO) {
        try {
            // Monta a URL com parâmetro para comunicar com API 
            String urlStr;
            if (DTO == null || DTO.isEmpty()) {
                urlStr = "http://localhost:8080/Cliente/";
            } else if (DTO.matches("\\d+")) {
                urlStr = "http://localhost:8080/Cliente/BuscarCliente/?id=" + DTO;
            } else {
                urlStr = "http://localhost:8080/Cliente/BuscarCliente/?nome=" + DTO;
                URLEncoder.encode(DTO, StandardCharsets.UTF_8);
            }

            // Abre conexão HTTP
            HttpURLConnection conexao = (HttpURLConnection) new URL(urlStr).openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Accept", "application/json");

            // Se resposta OK
            if (conexao.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (InputStream is = conexao.getInputStream()) {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(is, new TypeReference<List<Clientes>>() {
                    });
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar Cliente: " + e);
        }
        return List.of(); // retorna lista vazia se der erro
    }
      
      public boolean EditarCliente(String IdCliente, String Nome, String Email, String Telefone, String Endereco, String Cpf) {
        try {
            //abertura de conexao
            URL url = new URL("http://localhost:8080/Cliente/Editar/" + IdCliente);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"Nome\":\"" + Nome + "\","
                    + "\"email\":\"" + Email + "\","
                    + "\"telefone\":\"" + Telefone + "\","
                    + "\"cpf\":\"" + Cpf + "\","
                    + "\"endereco\":\"" + Endereco + "\""
                    + "}".formatted(Nome, Email, Telefone, Endereco, Cpf);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

    }
    
}
