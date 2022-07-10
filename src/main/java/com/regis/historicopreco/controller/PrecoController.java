package com.regis.historicopreco.controller;

import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.PrecoRequestDTO;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.repository.ProdutoRepository;
import com.regis.historicopreco.service.PrecoService;
import com.regis.historicopreco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos/{produtoId}/precos")
public class PrecoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PrecoService precoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarPreco(@PathVariable String produtoId, @Valid @RequestBody PrecoRequestDTO precoRequestDto) {
        ProdutoResponseDTO produtoResponseDto = produtoService.listarProdutoPorId(produtoId);
        if (produtoResponseDto == null) {
            return ResponseEntity.badRequest().body("produto com id" + produtoId + " não existe");
        }

        precoService.cadastrarPreco(precoRequestDto, produtoResponseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(precoRequestDto);
    }

}
