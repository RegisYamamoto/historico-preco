package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@Validated @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        try {
            ProdutoResponseDTO produtoResponseDTO = produtoService.listarProdutoPorId(produtoRequestDTO.getId());
            if (produtoResponseDTO != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("produto com id " + produtoRequestDTO.getId() + " já existe");
            }
            produtoService.cadastrarProduto(produtoRequestDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok().body(produtos);
    }

}
