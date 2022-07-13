package com.regis.historicopreco.service;

import com.regis.historicopreco.controller.Mocks;
import com.regis.historicopreco.model.dto.ProdutoRequestDTO;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProdutoServiceTest {

	@MockBean
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Test
	public void quandoChamoOMetodoCadastrarProdutoComSucesso_deveCadastrarComSucesso() throws Exception {
		produtoService.cadastrarProduto(Mocks.criarMockDeProdutoRequestDTO());
		verify(produtoRepository, times(1)).save(any());
	}

}
