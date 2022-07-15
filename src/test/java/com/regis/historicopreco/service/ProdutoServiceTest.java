package com.regis.historicopreco.service;

import com.regis.historicopreco.Mocks;
import com.regis.historicopreco.model.Produto;
import com.regis.historicopreco.model.dto.ProdutoResponseDTO;
import com.regis.historicopreco.model.dto.ProdutoResponsePageDTO;
import com.regis.historicopreco.repository.PrecoRepository;
import com.regis.historicopreco.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProdutoServiceTest {

	@MockBean
	private ProdutoRepository produtoRepository;

	@MockBean
	private PrecoRepository precoRepository;

	@Autowired
	private ProdutoService produtoService;


	// cenários para o método listarTodosProdutos()
	@Test
	public void quandoChamarOMetodoCadastrarProdutoComSucesso_deveCadastrarComSucesso() {
		produtoService.cadastrarProduto(Mocks.criarMockDeProdutoRequestDto());
		verify(produtoRepository, times(1)).save(any());
	}


	// cenários para o método listarProdutoPorId()
	@Test
	public void quandoChamarOMetodoListarProdutoPorId_deveRetornarTodosOsProdutosComSucesso() {
		List<Produto> produtosMock = new ArrayList<>();
		produtosMock.add(Mocks.criarMockDeProduto());

		Pageable pageable = PageRequest.of(0, 20, Sort.by("nome"));
		Page page = new PageImpl(produtosMock, pageable, 0L);

		when(produtoRepository.findAll(pageable)).thenReturn(page);

		assertEquals(Mocks.criarMockDeProdutoResponsePageDTO(), produtoService.listarTodosProdutos(0, 20));
	}


	// cenários para o método atualizarProduto()
	@Test
	public void quandoChamarOMetodoAtualizarProduto_deveAtualizarProdutoComSucesso() {
		produtoService.atualizarProduto(Mocks.criarMockDeProdutoRequestDto(), Mocks.criarMockDeProdutoResponseDto());
		verify(produtoRepository, times(1)).save(any());
	}


	// cenários para o método excluirProduto()
	@Test
	public void quandoChamarOMetodoExcluirProduto_deveExcluirOProdutoComSucesso() {
		produtoService.excluirProduto("asd123");
		verify(precoRepository, times(1)).deleteAllByProdutoId("asd123");
		verify(produtoRepository, times(1)).deleteById("asd123");
	}

}
