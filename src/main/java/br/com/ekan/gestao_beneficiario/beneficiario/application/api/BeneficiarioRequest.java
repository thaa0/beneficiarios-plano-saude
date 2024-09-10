package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ekan.gestao_beneficiario.documento.application.api.DocumetoRequest;
import lombok.Value;

@Value
public class BeneficiarioRequest {
	@NotBlank(message = "O campo não deve estar em branco")
	private String nomeCompleto;
	@NotBlank(message = "O campo não deve estar em branco")
	private String telefone;
	@NotNull
	private LocalDate dataNascimento;
	@NotEmpty
	@OneToMany
	private List<DocumetoRequest> documentos;
}