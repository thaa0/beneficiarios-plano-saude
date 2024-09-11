package br.com.ekan.gestao_beneficiario.beneficiario.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioListResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.repository.BeneficiarioRepository;
import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BeneficiarioApplicationService implements BeneficiarioService {

	private final BeneficiarioRepository beneficiarioRepository;

	@Override
	public BeneficiarioResponse cadastraBeneficiario(BeneficiarioRequest beneficiarioRequest) {
		log.info("[start] BeneficiarioApplicationService - cadastraBeneficiario");
		Beneficiario beneficiario = beneficiarioRepository.salva(new Beneficiario(beneficiarioRequest));
		log.info("[finish] BeneficiarioApplicationService - cadastraBeneficiario");
		return BeneficiarioResponse.builder()
				.idBeneficiario(beneficiario.getIdBeneficiario())
				.build();
	}

	@Override
	public List<BeneficiarioListResponse> buscaBeneficiarios() {
		log.info("[start] BeneficiarioApplicationService - cadastraBeneficiario");
		log.info("[finish] BeneficiarioApplicationService - cadastraBeneficiario");
		return null;
	}
}