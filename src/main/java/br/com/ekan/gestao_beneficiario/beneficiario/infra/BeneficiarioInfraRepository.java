package br.com.ekan.gestao_beneficiario.beneficiario.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ekan.gestao_beneficiario.beneficiario.application.repository.BeneficiarioRepository;
import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BeneficiarioInfraRepository implements BeneficiarioRepository {

	private final BeneficiarioSpringDataJPARepository beneficiarioSpringDataJPARepository;

	@Override
	public Beneficiario salva(Beneficiario beneficiario) {
		log.info("[start] BeneficiarioInfraRepository - salva");
		beneficiarioSpringDataJPARepository.save(beneficiario);
		log.info("[finish] BeneficiarioInfraRepository - salva");
		return beneficiario;
	}

	@Override
	public List<Beneficiario> buscaTodos() {
		log.info("[start] BeneficiarioInfraRepository - salva");
		List<Beneficiario> beneficiarios = beneficiarioSpringDataJPARepository.findAll();
		log.info("[finish] BeneficiarioInfraRepository - salva");
		return beneficiarios;
	}
}