package com.oficina.project.model.entities;

public class Administradores {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cargo;
    private String data_criacao;
    private String data_atualizacao;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() 
    { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getData_criacao() { return data_criacao; }
    public void setData_criacao(String data_criacao) { this.data_criacao = data_criacao; }

    public String getData_atualizacao() { return data_atualizacao; }
    public void setData_atualizacao(String data_atualizacao) { this.data_atualizacao = data_atualizacao; }
}