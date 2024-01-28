package com.br.products.controller;

import com.br.products.entity.Avaliacao;
import com.br.products.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> getAllAvaliacoes() {
        List<Avaliacao> avaliacoes = avaliacaoService.getAllAvaliacoes();
        return new ResponseEntity<>(avaliacoes, HttpStatus.OK);
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<Avaliacao>>getAvaliacoesProdutos(@PathVariable Long produtoId) {
        List<Avaliacao> avaliacoes = avaliacaoService.getAvaliacoesProdutos(produtoId);
        return new ResponseEntity<>(avaliacoes, HttpStatus.OK);
    }

    @PostMapping("/produto/{produtoId}")
    public ResponseEntity<Avaliacao> adicionarAvaliacao(@PathVariable Long produtoId, @RequestBody Avaliacao avaliacao) {
        Avaliacao novaAvaliacao = avaliacaoService.adicionarAvaliacao(produtoId, avaliacao);
        return new ResponseEntity<>(novaAvaliacao, HttpStatus.CREATED);
    }

    @DeleteMapping("/{avaliacaoId}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long id) {
        avaliacaoService.deleteAvaliacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
