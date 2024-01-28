package com.br.products.controller;

import com.br.products.request.ProdutoRequestDTO;
import com.br.products.response.ProdutoResponseDTO;
import com.br.products.service.ProdutoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@SecurityRequirement(name = "bearerAuth")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody ProdutoRequestDTO produtoRequest) {

        return ResponseEntity.ok(produtoService.criarProduto(produtoRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId (@PathVariable Long id){
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarTodosProduto (){
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosComFiltros(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) BigDecimal precoMin,
            @RequestParam(required = false) BigDecimal precoMax,
            @RequestParam(defaultValue = "asc") String ordenacao,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanhoPagina) {
        List<ProdutoResponseDTO> produtosFiltrados = produtoService.buscarProdutosComFiltros(categoria,precoMin,
                precoMax,ordenacao,pagina,tamanhoPagina);
        return ResponseEntity.ok(produtosFiltrados);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id,
                                                               @RequestBody ProdutoRequestDTO produtoRequest) {
        ProdutoResponseDTO produtoAtualizado = produtoService.atualizarProduto(id, produtoRequest);
        return ResponseEntity.ok(produtoAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
