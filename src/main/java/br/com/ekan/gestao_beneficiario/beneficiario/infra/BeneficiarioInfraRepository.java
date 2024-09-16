package br.com.ekan.gestao_beneficiario.beneficiario.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.ekan.gestao_beneficiario.beneficiario.application.repository.BeneficiarioRepository;
import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import br.com.ekan.gestao_beneficiario.beneficiario.handler.APIException;
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

	@Override
	public Beneficiario buscaBeneficiarioPeloId(UUID idBeneficiario) {
		Beneficiario beneficiario = beneficiarioSpringDataJPARepository.findById(idBeneficiario)
				.orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Beneficiário não encontrado"));
		return beneficiario;
	}

	@Override
	public void deleta(UUID idBeneficiario) {
		log.info("[start] BeneficiarioInfraRepository - deleta");
		beneficiarioSpringDataJPARepository.deleteById(idBeneficiario);
		log.info("[finish] BeneficiarioInfraRepository - deleta");		
	}
}