package br.com.ekan.gestao_beneficiario.beneficiario.application.repository;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;

public interface BeneficiarioRepository {
	Beneficiario salva(Beneficiario beneficiario);
}