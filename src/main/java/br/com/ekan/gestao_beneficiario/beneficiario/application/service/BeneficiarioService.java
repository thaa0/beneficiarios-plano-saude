package br.com.ekan.gestao_beneficiario.beneficiario.application.service;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioResponse;

public interface BeneficiarioService {
	BeneficiarioResponse cadastraBeneficiario(BeneficiarioRequest beneficiarioRequest);
}