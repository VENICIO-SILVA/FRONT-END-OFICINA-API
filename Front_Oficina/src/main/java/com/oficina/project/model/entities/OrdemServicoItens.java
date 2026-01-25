package com.oficina.project.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class OrdemServicoItens {

    @JsonProperty("id")
    private int id;

    @JsonProperty("quantidade")
    private int quantidade;

    @JsonProperty("PrecoUnitario")
    private BigDecimal precoUnitario;

    @JsonProperty("ordemServico")
    private OrdemServico ordemServico;

    @JsonProperty("produto")
    private Produtos produto;

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }
    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Produtos getProduto() {
        return produto;
    }
    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}