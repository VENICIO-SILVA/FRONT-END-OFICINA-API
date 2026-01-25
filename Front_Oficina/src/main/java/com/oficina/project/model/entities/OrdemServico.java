package com.oficina.project.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrdemServico {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("Observacoes")
    private String observacoes;

    @JsonProperty("NumeroOS")
    private String numeroOs;

    @JsonProperty("Tipo")
    private String tipo; // no front pode ser String

    @JsonProperty("Status")
    private String status; // idem

    @JsonProperty("DataCadastro")
    private Timestamp dataCadastro;

    @JsonProperty("DataAtualizacao")
    private Timestamp dataAtualizacao;

    @JsonProperty("maoDeObra")
    private BigDecimal maoDeObra;

    @JsonProperty("Cliente")
    private Clientes cliente;

    @JsonProperty("ordemServicoItens")
    private List<OrdemServicoItens> ordemServicoItens;

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNumeroOs() {
        return numeroOs;
    }
    public void setNumeroOs(String numeroOs) {
        this.numeroOs = numeroOs;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public BigDecimal getMaoDeObra() {
        return maoDeObra;
    }
    public void setMaoDeObra(BigDecimal maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<OrdemServicoItens> getOrdemServicoItens() {
        return ordemServicoItens;
    }
    public void setOrdemServicoItens(List<OrdemServicoItens> ordemServicoItens) {
        this.ordemServicoItens = ordemServicoItens;
    }
}