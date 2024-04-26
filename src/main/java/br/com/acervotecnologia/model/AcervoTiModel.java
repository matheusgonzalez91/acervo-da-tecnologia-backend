package br.com.acervotecnologia.model;

import br.com.acervotecnologia.dto.AcervoTiRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AcervoTiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String imgLivro;
    private String nomeLivro;
    private String nomeAutor;
    private String anoLancamento;
    private String descLivro;
    private String categoria;
    private String livroUrlDownload;

    public AcervoTiModel(AcervoTiRequestDTO data){
        this.imgLivro = data.imgLivro();
        this.nomeLivro = data.nomeLivro();
        this.nomeAutor = data.nomeAutor();
        this.anoLancamento = data.anoLancamento();
        this.descLivro = data.descLivro();
        this.categoria = data.categoria();
        this.livroUrlDownload = data.livroUrlDownload();
    }
}
