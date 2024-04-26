package br.com.acervotecnologia.dto;

import br.com.acervotecnologia.model.AcervoTiModel;

import java.util.UUID;

public record AcervoTiResponseDTO(UUID id, String imgLivro, String nomeLivro, String nomeAutor,String anoLancamento, String descLivro, String categoria, String livroUrlDownload) {
    public AcervoTiResponseDTO(AcervoTiModel acervo){
        this(acervo.getId(), acervo.getImgLivro(), acervo.getNomeLivro(), acervo.getNomeAutor(), acervo.getAnoLancamento(), acervo.getDescLivro(), acervo.getCategoria(), acervo.getLivroUrlDownload());
    }
}