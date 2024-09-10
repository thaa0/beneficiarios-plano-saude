package br.com.ekan.gestao_beneficiario.documento.application.api;

import javax.validation.constraints.NotBlank;

public class DocumetoRequest {
	@NotBlank(message = "O campo não deve estar em branco")
	private String tipoDocumento;
	@NotBlank(message = "O campo não deve estar em branco")
	private String descricao;
}