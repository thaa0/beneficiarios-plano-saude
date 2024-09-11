package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.gestao_beneficiario.beneficiario.application.service.BeneficiarioService;
import br.com.ekan.gestao_beneficiario.documento.application.api.DocumentoListResponse;
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

	@Override
	public List<BeneficiarioListResponse> getBeneficiarios() {
		log.info("[start] BeneficiarioController - getBeneficiarios");
		List<BeneficiarioListResponse> beneficiarios = beneficiarioService.buscaBeneficiarios();
		log.info("[finish] BeneficiarioController - getBeneficiarios");
		return beneficiarios;
	}

	@Override
	public List<DocumentoListResponse> getDocumentosBeneficiario(UUID idBeneficiario) {
		log.info("[start] BeneficiarioController - getBeneficiarios");
		List<DocumentoListResponse> beneficiarios = beneficiarioService.buscaDocumentos(idBeneficiario);
		log.info("[finish] BeneficiarioController - getBeneficiarios");
		return beneficiarios;
	}
}