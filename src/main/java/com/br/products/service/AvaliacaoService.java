package com.br.products.service;

import com.br.products.entity.Avaliacao;
import com.br.products.entity.Produto;
import com.br.products.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> getAllAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> getAvaliacoesProdutos(Long id) {
        return avaliacaoRepository.findByProdutoId(id);
    }

    public Avaliacao adicionarAvaliacao(Long produtoId, Avaliacao avaliacao) {
        avaliacao.setProduto((Produto) avaliacaoRepository.findByProdutoId(produtoId));
        return avaliacaoRepository.save(avaliacao);
    }

    public void deleteAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }

}
