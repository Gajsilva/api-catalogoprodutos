package com.br.products.service;

import com.br.products.entity.Produto;
import com.br.products.repository.ProdutoRepository;
import com.br.products.response.ProdutoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ModelMapper modelMapper;
private final ProdutoRepository produtoRepository;

    public ProdutoService(ModelMapper modelMapper, ProdutoRepository produtoRepository) {
        this.modelMapper = modelMapper;
        this.produtoRepository = produtoRepository;
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
}
