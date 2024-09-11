package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import lombok.Value;

@Value
public class BeneficiarioListResponse {
	private String nomeCompleto;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataInclusao;
	private LocalDate ultimaAtualizacao;
	
	
	public static List<BeneficiarioListResponse> converte(List<Beneficiario> beneficiarios) {
		return beneficiarios.stream()
				.map(BeneficiarioListResponse::new)
				.collect(Collectors.toList());
	}


	public BeneficiarioListResponse(Beneficiario beneficiario) {
		this.nomeCompleto = beneficiario.getNomeCompleto();
		this.telefone = beneficiario.getTelefone();
		this.dataNascimento = beneficiario.getDataNascimento();
		this.dataInclusao = beneficiario.getDataInclusao();
		this.ultimaAtualizacao = beneficiario.getUltimaAtualizacao();
	}
}