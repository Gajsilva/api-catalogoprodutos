package com.br.products.util;

import com.br.products.entity.Produto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecifications {

    public static Specification<Produto> porCategoria(String categoria) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoria"), categoria);
    }

    public static Specification<Produto> precoMaiorOuIgual(BigDecimal preco) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), preco);
    }

    public static Specification<Produto> precoMenorOuIgual(BigDecimal preco) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("preco"), preco);
    }

    public static Specification<Produto> orderByPrecoAsc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("preco")));
            return null;
        };
    }

    public static Specification<Produto> orderByPrecoDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("preco")));
            return null;
        };
    }
}

