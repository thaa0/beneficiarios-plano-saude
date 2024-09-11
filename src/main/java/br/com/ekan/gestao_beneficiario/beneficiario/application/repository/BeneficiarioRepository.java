package br.com.ekan.gestao_beneficiario.beneficiario.application.repository;

import java.util.List;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;

public interface BeneficiarioRepository {
	Beneficiario salva(Beneficiario beneficiario);
	List<Beneficiario> buscaTodos();
}