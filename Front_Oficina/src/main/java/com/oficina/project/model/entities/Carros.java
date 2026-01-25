package com.oficina.project.model.entities;

public class Carros {

    private Integer id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String cor;
    private String placa;
    private String DataCadastro;
    private String DataAtualizacao;

    public String getData_Cadastro() {
        return DataCadastro;
    }

    public void setData_Cadastro(String data_Cadastro) {
        this.DataCadastro = data_Cadastro;
    }

    public String getData_Atualizacao() {
        return DataAtualizacao;
    }

    public void setData_Atualizacao(String data_Atualizacao) {
        this.DataAtualizacao = data_Atualizacao;
    }

    // Construtor padrão (necessário para o Jackson)
    public Carros() {
    }

    // Getters e Setters no padrão JavaBeans
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
