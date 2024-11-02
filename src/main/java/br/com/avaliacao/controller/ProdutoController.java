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

import br.com.avaliacao.model.Produto;
import br.com.avaliacao.service.ProdutoService;

@RestController
@RequestMapping("/api/product")
public class ProdutoController {

	@Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.createProduto(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto updatedProduto = produtoService.update(id, produto);
        return updatedProduto != null ? ResponseEntity.ok(updatedProduto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


