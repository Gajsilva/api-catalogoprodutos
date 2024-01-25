package com.br.products.response;

import java.time.LocalDateTime;

public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private String image;
    private double quantidadeEstoque;
    private LocalDateTime dataCriacao;
    private String tags;
    private double custoUnitario;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImage() {
        return image;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getTags() {
        return tags;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }
}
