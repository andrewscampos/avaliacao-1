package br.com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.mapper.ProdutoMappper;
import br.com.avaliacao.model.Produto;
import br.com.avaliacao.model.repository.ProdutoRepository;
import br.com.avaliacao.request.ProdutoRequest;
import br.com.avaliacao.response.ProdutoResponse;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoMappper produtoMappper;

	public ProdutoResponse createProduto(ProdutoRequest request) {
		 Produto produto = produtoRepository.save(produtoMappper.toModel(request));
		 return produtoMappper.toResponse(produto);
	}

	public List<ProdutoResponse> getAllProdutos() {
		return produtoRepository.findAll().stream().map(a -> produtoMappper.toResponse(a)).toList();
	}

	public Optional<ProdutoResponse> findById(Long id) {
		return Optional.of(produtoMappper.toResponse(produtoRepository.findById(id).orElse(null)));
	}

	public ProdutoResponse update(Long id, ProdutoRequest produto) {
		Optional<Produto> existingProduto = produtoRepository.findById(id);
		if (existingProduto.isPresent()) {
			Produto produtoToUpdate = existingProduto.get();
			produtoToUpdate.setNome(produto.getNome());
			produtoToUpdate.setDescricao(produto.getDescricao());
			produtoToUpdate.setPreco(produto.getPreco());
			return produtoMappper.toResponse(produtoRepository.save(produtoToUpdate));
		}
		return null;
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
}
