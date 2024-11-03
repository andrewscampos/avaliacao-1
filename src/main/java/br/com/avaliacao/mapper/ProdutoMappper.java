package br.com.avaliacao.mapper;

import org.mapstruct.Mapper;

import br.com.avaliacao.model.Produto;
import br.com.avaliacao.request.ProdutoRequest;
import br.com.avaliacao.response.ProdutoResponse;

@Mapper(componentModel = "spring")
public interface ProdutoMappper {

	ProdutoResponse toResponse(Produto user);
	
	Produto toModel(ProdutoRequest request);
	
}
