package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.time.LocalDate;

import lombok.Value;

@Value
public class BeneficiarioListResponse {
	private String nomeCompleto;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataInclusao;
	private LocalDate ultimaAtualizacao;
}