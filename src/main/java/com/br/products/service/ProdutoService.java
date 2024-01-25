package com.br.products.service;

import com.br.products.entity.Produto;
import com.br.products.repository.ProdutoRepository;
import com.br.products.request.ProdutoRequestDTO;
import com.br.products.response.ProdutoResponseDTO;
import com.br.products.util.ProdutoSpecifications;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ModelMapper modelMapper;
private final ProdutoRepository produtoRepository;

    public ProdutoService(ModelMapper modelMapper, ProdutoRepository produtoRepository) {
        this.modelMapper = modelMapper;
        this.produtoRepository = produtoRepository;
    }
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequest) {
        Produto produto = modelMapper.map(produtoRequest, Produto.class);
        Produto savedProduto = produtoRepository.save(produto);
        return modelMapper.map(savedProduto, ProdutoResponseDTO.class);
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO produtoRequest) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        modelMapper.map(produtoRequest, produto);
        Produto updatedProduto = produtoRepository.save(produto);
        return modelMapper.map(updatedProduto, ProdutoResponseDTO.class);
    }
    public ProdutoResponseDTO buscarProdutoPorId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException(""));

        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }

    public List<ProdutoResponseDTO> buscarProdutosComFiltros(String categoria, Double precoMin, Double precoMax, String ordenacao) {
        Specification<Produto> specification = Specification.where(null);

        if (categoria != null && !categoria.isEmpty()) {
            specification = specification.and(ProdutoSpecifications.porCategoria(categoria));
        }

        if (precoMin != null) {
            specification = specification.and(ProdutoSpecifications.precoMaiorOuIgual(precoMin));
        }

        if (precoMax != null) {
            specification = specification.and(ProdutoSpecifications.precoMenorOuIgual(precoMax));
        }

        List<Produto> produtos = produtoRepository.findAll(specification);

        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List <ProdutoResponseDTO> buscarTodosProdutos(){
        List <Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class))
                .collect(Collectors.toList());
    }

    public void excluirProduto(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }
}
