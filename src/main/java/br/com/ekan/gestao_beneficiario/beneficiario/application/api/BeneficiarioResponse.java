package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BeneficiarioResponse {
	private UUID idBeneficiario;
}