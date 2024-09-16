package br.com.ekan.gestao_beneficiario.documento.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ekan.gestao_beneficiario.documento.domain.Documento;
import lombok.Value;

@Value
public class DocumentoListResponse {
	private UUID idDocumento;	
	private String tipoDocumento;	
	private String descricao;	
	private LocalDate dataInclusao;
	private LocalDate dataAtualizacao;
	
	
	public static List<DocumentoListResponse> converte(List<Documento> documentos) {
		return documentos.stream()
				.map(DocumentoListResponse::new)
				.collect(Collectors.toList());
	}

	public DocumentoListResponse(Documento documento) {
		this.idDocumento = documento.getIdDocumento();
		this.tipoDocumento = documento.getTipoDocumento();
        this.descricao = documento.getDescricao();
        this.dataInclusao = documento.getDataInclusao();
        this.dataAtualizacao = documento.getDataAtualizacao();
	}
}