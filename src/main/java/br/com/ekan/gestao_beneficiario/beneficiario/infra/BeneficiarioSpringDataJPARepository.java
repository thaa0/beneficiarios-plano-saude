package br.com.ekan.gestao_beneficiario.beneficiario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;

public interface BeneficiarioSpringDataJPARepository extends JpaRepository<Beneficiario, UUID> {

}