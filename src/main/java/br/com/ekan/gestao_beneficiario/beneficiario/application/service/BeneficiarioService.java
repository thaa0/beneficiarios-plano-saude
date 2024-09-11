package br.com.ekan.gestao_beneficiario.beneficiario.application.service;

import java.util.List;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioListResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioResponse;

public interface BeneficiarioService {
	BeneficiarioResponse cadastraBeneficiario(BeneficiarioRequest beneficiarioRequest);
	List<BeneficiarioListResponse> buscaBeneficiarios();
}