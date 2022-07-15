package com.regis.historicopreco.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoResponsePageDTO {

    private int page = 0;
    private int size = 0;
    private int totalPages = 0;
    private List<ProdutoResponseDTO> produtosResponseDto= new ArrayList<>();

}
