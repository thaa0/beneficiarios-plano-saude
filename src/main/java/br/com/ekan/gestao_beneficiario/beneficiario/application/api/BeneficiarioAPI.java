package br.com.ekan.gestao_beneficiario.beneficiario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.gestao_beneficiario.documento.application.api.DocumentoListResponse;

@RestController
@RequestMapping("/v1/beneficiario")
public interface BeneficiarioAPI {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	BeneficiarioResponse postBeneficiario(@RequestBody BeneficiarioRequest beneficiarioRequest);
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<BeneficiarioListResponse> getBeneficiarios();
	
	@GetMapping("/{idBeneficiario}/documentos")
	@ResponseStatus(HttpStatus.OK)
	List<DocumentoListResponse> getDocumentosBeneficiario(@PathVariable UUID idBeneficiario);
}