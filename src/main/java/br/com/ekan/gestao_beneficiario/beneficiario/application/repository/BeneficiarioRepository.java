package br.com.ekan.gestao_beneficiario.beneficiario.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;

public interface BeneficiarioRepository {
	Beneficiario salva(Beneficiario beneficiario);
	List<Beneficiario> buscaTodos();
	Beneficiario buscaBeneficiarioPeloId(UUID idBeneficiario);
	void deleta(UUID idBeneficiario);
}