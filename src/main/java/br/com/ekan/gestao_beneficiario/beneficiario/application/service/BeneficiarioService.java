package br.com.ekan.gestao_beneficiario.beneficiario.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioAlteraRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioListResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioResponse;
import br.com.ekan.gestao_beneficiario.documento.application.api.DocumentoListResponse;

public interface BeneficiarioService {
	BeneficiarioResponse cadastraBeneficiario(BeneficiarioRequest beneficiarioRequest);
	List<BeneficiarioListResponse> buscaBeneficiarios();
	List<DocumentoListResponse> buscaDocumentos(UUID idBeneficiario);
	void atualizaBeneficiario(@Valid BeneficiarioAlteraRequest beneficiarioAlteraRequest, UUID idBeneficiario);
	void deletaBeneficiario(UUID idBeneficiario);
}