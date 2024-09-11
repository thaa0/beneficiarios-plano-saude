package br.com.ekan.gestao_beneficiario.documento.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid",name = "id", nullable = false, unique = true, updatable = false)
	private UUID idDocumento;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Beneficiario beneficiario;
	@NotBlank(message = "O campo não deve estar em branco")
	private String tipoDocumento;
	@NotBlank(message = "O campo não deve estar em branco")
	private String descricao;
	
	private LocalDate dataInclusao;
	private LocalDate dataAtualizacao;
}