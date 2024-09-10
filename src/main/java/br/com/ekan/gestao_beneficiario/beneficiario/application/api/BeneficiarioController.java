package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.gestao_beneficiario.beneficiario.application.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BeneficiarioController implements BeneficiarioAPI {

	private final BeneficiarioService beneficiarioService;

	@Override
	public BeneficiarioResponse postBeneficiario(BeneficiarioRequest beneficiarioRequest) {
		log.info("[start] BeneficiarioController - postBeneficiario");
		BeneficiarioResponse beneficiarioCadastrado = beneficiarioService.cadastraBeneficiario(beneficiarioRequest);
		log.info("[finish] BeneficiarioController - postBeneficiario");
		return beneficiarioCadastrado;
	}
}