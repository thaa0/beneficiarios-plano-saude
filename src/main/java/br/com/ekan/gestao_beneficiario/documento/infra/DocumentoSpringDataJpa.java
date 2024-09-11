package br.com.ekan.gestao_beneficiario.documento.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekan.gestao_beneficiario.documento.domain.Documento;

public interface DocumentoSpringDataJpa extends JpaRepository<Documento, UUID>{

}