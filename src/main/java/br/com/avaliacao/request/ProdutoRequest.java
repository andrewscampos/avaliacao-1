package br.com.avaliacao.request;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProdutoRequest {

    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória.")
    @Size(max = 255, message = "A descrição do produto deve ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ser um valor numérico com até 10 dígitos e 2 casas decimais.")
    private BigDecimal preco;
}
