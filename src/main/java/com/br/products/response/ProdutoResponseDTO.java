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
}
