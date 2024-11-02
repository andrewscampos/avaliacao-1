package br.com.avaliacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}