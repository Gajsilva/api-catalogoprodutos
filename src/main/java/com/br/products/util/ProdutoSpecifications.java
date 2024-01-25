package com.br.products.util;

import com.br.products.entity.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecifications {
    public static Specification<Produto> porCategoria(String categoria) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoria"), categoria);
    }

    public static Specification<Produto> precoMaiorOuIgual(Double preco) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), preco);
    }

    public static Specification<Produto> precoMenorOuIgual(Double preco) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("preco"), preco);
    }
}

