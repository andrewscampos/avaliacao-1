package br.com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.model.Produto;
import br.com.avaliacao.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto createProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto update(Long id, Produto produto) {
		Optional<Produto> existingProduto = produtoRepository.findById(id);
		if (existingProduto.isPresent()) {
			Produto produtoToUpdate = existingProduto.get();
			produtoToUpdate.setNome(produto.getNome());
			produtoToUpdate.setDescricao(produto.getDescricao());
			produtoToUpdate.setPreco(produto.getPreco());
			return produtoRepository.save(produtoToUpdate);
		}
		return null;
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
}
