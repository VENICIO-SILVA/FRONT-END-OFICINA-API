/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficina.project.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oficina.project.model.entities.Administradores;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Venicio
 *
 */
public class AdministradoresService {

    public boolean Cadastrar(String Nome, String Email, String Senha, String Cargo, String Telefone) {
        try {
            URL url = new URL("http://localhost:8080/Administradores/Cadastrar");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"nome\":\"" + Nome + "\","
                    + "\"email\":\"" + Email + "\","
                    + "\"senha\":\"" + Senha + "\","
                    + "\"cargo\":\"" + Cargo + "\","
                    + "\"telefone\":\"" + Telefone + "\""
                    + "}".formatted(Nome, Email, Senha, Cargo, Telefone);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<Administradores> BuscarAdministradores(String DTO) {
        try {
            // Monta a URL com parâmetro para comunicar com API 
            String urlStr;
            if (DTO == null || DTO.isEmpty()) {
                urlStr = "http://localhost:8080/Administradores/BuscarUsuario";
            } else if (DTO.matches("\\d+")) {
                urlStr = "http://localhost:8080/Administradores/BuscarUsuario/?id=" + DTO;
            } else {
                urlStr = "http://localhost:8080/Administradores/BuscarUsuario/?nome=" + DTO;
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
                    return mapper.readValue(is, new TypeReference<List<Administradores>>() {
                    });
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar administradores: " + e);
        }
        return List.of(); // retorna lista vazia se der erro
    }

    public boolean ApagarUsuario(String DTO) {
        try {
            //abertura de conexao
            URL url = new URL("http://localhost:8080/Administradores/ExcluirUsuario/" + DTO);
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

    public boolean EditarUsuario(String IdUsuario, String Nome, String Email, String Senha, String Cargo, String Telefone) {
        try {
            //abertura de conexao
            URL url = new URL("http://localhost:8080/Administradores/EditarUsuario/" + IdUsuario);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"nome\":\"" + Nome + "\","
                    + "\"email\":\"" + Email + "\","
                    + "\"senha\":\"" + Senha + "\","
                    + "\"cargo\":\"" + Cargo + "\","
                    + "\"telefone\":\"" + Telefone + "\""
                    + "}".formatted(Nome, Email, Senha, Cargo, Telefone);

            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

    }
}
