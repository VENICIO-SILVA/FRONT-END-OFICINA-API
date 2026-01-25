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
public class LoginService {
  public boolean login(String email, String senha) {
        try {
            URL url = new URL("http://localhost:8080/Administradores/Login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
        + "\"email\":\"" + email + "\","
        + "\"senha\":\"" + senha + "\""
        + "}".formatted(email, senha);


            conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

            int status = conn.getResponseCode();
            return status == 200;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
