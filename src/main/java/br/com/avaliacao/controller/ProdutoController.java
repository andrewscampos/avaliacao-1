package br.com.avaliacao.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.request.ProdutoRequest;
import br.com.avaliacao.response.ProdutoResponse;
import br.com.avaliacao.service.ProdutoService;

@RestController
@RequestMapping("/api/product")
public class ProdutoController {

	@Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> createProduto(@RequestBody ProdutoRequest produto) {
        ProdutoResponse novoProduto = produtoService.createProduto(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAllProdutos() {
        List<ProdutoResponse> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        Optional<ProdutoResponse> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoRequest produto) {
    	ProdutoResponse updatedProduto = produtoService.update(id, produto);
        return updatedProduto != null ? ResponseEntity.ok(updatedProduto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


