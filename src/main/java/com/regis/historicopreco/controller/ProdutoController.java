package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Object> cadastrarProduto(@Valid @RequestBody ProdutoRequestDTO produtoRequestDto) {
        ProdutoResponseDTO produtoResponseDto = produtoService.listarProdutoPorId(produtoRequestDto.getId());
        if (produtoResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("produto com id " + produtoRequestDto.getId() + " já existe");
        }
        produtoService.cadastrarProduto(produtoRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok().body(produtos);
    }

}
