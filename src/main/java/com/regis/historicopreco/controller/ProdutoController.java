package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity salvarProduto(@Validated @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        try {
            produtoService.salvarProduto(produtoRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

        return ResponseEntity.ok().body(produtoRequestDTO);
    }

}
