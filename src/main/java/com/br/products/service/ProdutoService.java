package com.br.products.service;

import com.br.products.entity.Produto;
import com.br.products.repository.ProdutoRepository;
import com.br.products.request.ProdutoRequestDTO;
import com.br.products.response.ProdutoResponseDTO;
import com.br.products.util.ProdutoSpecifications;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Base64;
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
    public List<ProdutoResponseDTO> buscarProdutosComFiltros(String categoria, BigDecimal precoMin, BigDecimal precoMax,
                                                             String ordenacao, int pagina, int tamanhoPagina) {
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

        Sort sort = Sort.unsorted();

        if ("asc".equalsIgnoreCase(ordenacao)) {
            specification = specification.and(ProdutoSpecifications.orderByPrecoAsc());
        } else if ("desc".equalsIgnoreCase(ordenacao)) {
            specification = specification.and(ProdutoSpecifications.orderByPrecoDesc());
        }

        Pageable pageable = PageRequest.of(pagina, tamanhoPagina, sort);

        Page<Produto> produtosPage = produtoRepository.findAll(specification, pageable);

        return produtosPage.getContent()
                .stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class))
                .collect(Collectors.toList());
    }
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequest) {
        produtoRepository.findByNome(produtoRequest.getNome())
                .ifPresent(existingProduto -> {
                    throw new RuntimeException("Produto com o mesmo nome já existe");
                });

        Produto produto = modelMapper.map(produtoRequest, Produto.class);

        if (produtoRequest.getImage() != null) {
            byte[] imagemBytes = produtoRequest.getImage().getBytes();
            String imagemBase64 = Base64.getEncoder().encodeToString(imagemBytes);
            produto.setImage(imagemBase64);
        }

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
