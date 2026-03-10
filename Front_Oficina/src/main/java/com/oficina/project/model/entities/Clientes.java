package com.oficina.project.model.entities;

import java.util.List;

public class Clientes {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;
    private String dataCadastro;     // ✅ camelCase
    private String dataAtualizacao;  // ✅ camelCase

    private List<OrdemServico> ordemServico; // só se o back mandar
    private List<Carros> carros;             // já vem convertido no back

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(String dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public List<OrdemServico> getOrdemServico() { return ordemServico; }
    public void setOrdemServico(List<OrdemServico> ordemServico) { this.ordemServico = ordemServico; }

    public List<Carros> getCarros() { return carros; }
    public void setCarros(List<Carros> carros) { this.carros = carros; }
}