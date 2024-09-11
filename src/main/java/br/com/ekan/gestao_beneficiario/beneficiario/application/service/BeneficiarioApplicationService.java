package br.com.ekan.gestao_beneficiario.beneficiario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioListResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioRequest;
import br.com.ekan.gestao_beneficiario.beneficiario.application.api.BeneficiarioResponse;
import br.com.ekan.gestao_beneficiario.beneficiario.application.repository.BeneficiarioRepository;
import br.com.ekan.gestao_beneficiario.beneficiario.domain.Beneficiario;
import br.com.ekan.gestao_beneficiario.documento.application.api.DocumentoListResponse;
import br.com.ekan.gestao_beneficiario.documento.domain.Documento;
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
		List<Beneficiario> beneficiarios = beneficiarioRepository.buscaTodos();
		log.info("[finish] BeneficiarioApplicationService - cadastraBeneficiario");
		return BeneficiarioListResponse.converte(beneficiarios);
	}

	@Override
	public List<DocumentoListResponse> buscaDocumentos(UUID idBeneficiario) {
		log.info("[start] BeneficiarioApplicationService - cadastraBeneficiario");
		Beneficiario beneficiario = beneficiarioRepository.buscaBeneficiarioPeloId(idBeneficiario);
		List<Documento> documentos = beneficiario.getDocumentos();		
		log.info("[finish] BeneficiarioApplicationService - {}", documentos);
		log.info("[finish] BeneficiarioApplicationService - cadastraBeneficiario");
		return DocumentoListResponse.converte(documentos);
	}
}