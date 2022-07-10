package com.regis.historicopreco.service;

import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProdutoServiceTest {

	@Mock
	private ProdutoRepository produtoRepository;

	@InjectMocks
	private ProdutoService produtoService;

	@Test
	public void deveTestarMetodoCadastrarProdutoComSucesso() throws Exception {
		ProdutoRequestDTO produtoRequestDtoMock = new ProdutoRequestDTO();
		produtoRequestDtoMock.setId("aww");
		produtoRequestDtoMock.setNome("banana");
		produtoRequestDtoMock.setDescricao("banana");
		produtoRequestDtoMock.setMarca("Panasonic");
		produtoService.cadastrarProduto(produtoRequestDtoMock);
		verify(produtoRepository, times(1)).save(any());
	}

}
