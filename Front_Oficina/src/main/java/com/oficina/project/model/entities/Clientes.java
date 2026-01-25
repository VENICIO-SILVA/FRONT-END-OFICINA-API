package com.oficina.project.model.entities;

import java.util.List;

public class Clientes {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;
    private String data_cadastro;
    private String data_atualizacao;
    private List<OrdemServico> ordemServico;
    //O json do back precisa desses campo no front
    public List<OrdemServico> getOrdemServico() {
        return ordemServico;
    }
    public void setOrdemServico(List<OrdemServico> ordemServico) {
        this.ordemServico = ordemServico;
    }

    private List<Carros> carros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(String data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public List<Carros> getCarros() {
        return carros;
    }

    public void setCarros(List<Carros> carros) {
        this.carros = carros;
    }
}
