package br.com.acervotecnologia.repositories;

import br.com.acervotecnologia.model.AcervoTiModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AcervoTiRepository extends JpaRepository<AcervoTiModel, UUID> {
    List<AcervoTiModel> findByNomeLivroIgnoreCaseContaining(String titulo);
    List<AcervoTiModel> findByCategoria(String categoria);
}
