package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.ekan.gestao_beneficiario.documento.domain.Documento;
import lombok.Value;

@Value
public class BeneficiarioAlteraRequest {
	@NotBlank(message = "O campo não deve estar em branco")
	private String nomeCompleto;
	@NotBlank(message = "O campo não deve estar em branco")
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
	private String telefone;
	@NotNull
	private LocalDate dataNascimento;
	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "beneficiario")
	private List<Documento> documentos;
	private LocalDate dataAlteracao;
}