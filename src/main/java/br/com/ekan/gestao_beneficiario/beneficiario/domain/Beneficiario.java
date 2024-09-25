package br.com.ekan.gestao_beneficiario.beneficiario.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioAlteraRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.documento.domain.Documento;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid",name = "id", nullable = false, unique = true, updatable = false)
	private UUID idBeneficiario;
	@NotBlank(message = "O campo não deve estar em branco")
	private String nomeCompleto;
	@NotBlank(message = "O campo não deve estar em branco")
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
	private String telefone;
	@NotNull
	private LocalDate dataNascimento;
	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiario")
	private List<Documento> documentos;
	
	private LocalDate dataInclusao;
	private LocalDate ultimaAtualizacao;
	
	public Beneficiario(BeneficiarioRequest beneficiarioRequest) {
		this.nomeCompleto = beneficiarioRequest.getNomeCompleto();
		this.telefone = beneficiarioRequest.getTelefone();
		this.dataNascimento = beneficiarioRequest.getDataNascimento();
		this.dataInclusao = LocalDate.now();
		if(beneficiarioRequest.getDocumentos()!=null) {
			this.documentos = beneficiarioRequest.getDocumentos();
			for (Documento documento:this.documentos) {
				documento.setBeneficiario(this);
				documento.setDataInclusao(LocalDate.now());
			}
		}
	}

	public void altera(@Valid BeneficiarioAlteraRequest beneficiarioAlteraRequest) {
	    atualizarInformacoesBasicas(beneficiarioAlteraRequest);
	    
	    if (Objects.nonNull(beneficiarioAlteraRequest.getDocumentos())) {
	        atualizarDocumentos(beneficiarioAlteraRequest.getDocumentos());
	    }
	}

	private void atualizarInformacoesBasicas(BeneficiarioAlteraRequest beneficiarioAlteraRequest) {
	    this.nomeCompleto = beneficiarioAlteraRequest.getNomeCompleto();
	    this.telefone = beneficiarioAlteraRequest.getTelefone();
	    this.dataNascimento = beneficiarioAlteraRequest.getDataNascimento();
	    this.ultimaAtualizacao = LocalDate.now();
	}

	private void atualizarDocumentos(List<Documento> novosDocumentos) {
	    novosDocumentos.forEach(this::processarDocumento);
	}

	private void processarDocumento(Documento documentoNovo) {
	    Documento documentoExistente = buscarDocumentoExistente(documentoNovo.getIdDocumento());

	    if (Objects.nonNull(documentoExistente)) {
	        atualizarDocumento(documentoExistente, documentoNovo);
	    } else {
	        adicionarNovoDocumento(documentoNovo);
	    }
	}

	private Documento buscarDocumentoExistente(UUID documentoId) {
	    return this.documentos.stream()
	        .filter(doc -> Objects.equals(doc.getIdDocumento(), documentoId))
	        .findFirst()
	        .orElse(null);
	}

	private void atualizarDocumento(Documento documentoExistente, Documento documentoNovo) {
		documentoExistente.setTipoDocumento(documentoNovo.getTipoDocumento());
		documentoExistente.setDescricao(documentoNovo.getDescricao());  // Exemplo: atualiza dados do documento 
	    documentoExistente.setDataAtualizacao(LocalDate.now());
	}

	private void adicionarNovoDocumento(Documento documentoNovo) {
	    documentoNovo.setBeneficiario(this);
	    documentoNovo.setDataInclusao(LocalDate.now());
	    this.documentos.add(documentoNovo);
	}
}