package br.com.acervotecnologia.controller;

import br.com.acervotecnologia.dto.AcervoTiRequestDTO;
import br.com.acervotecnologia.dto.AcervoTiResponseDTO;
import br.com.acervotecnologia.model.AcervoTiModel;
import br.com.acervotecnologia.repositories.AcervoTiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "https://acervotecnologia.netlify.app/")
@RequestMapping("/livros")
public class AcervoTiController {

    @Autowired
    private AcervoTiRepository acervoTiRepository;

    @GetMapping
    public List<AcervoTiResponseDTO> getAllBooks(){
        List<AcervoTiResponseDTO> acervoList = acervoTiRepository.findAll().stream().map(AcervoTiResponseDTO::new).toList();
        return acervoList;
    }

    @GetMapping(params = "titulo")
    public List<AcervoTiResponseDTO> getBooksByTitulo(@RequestParam String titulo){
        List<AcervoTiResponseDTO> acervoList = acervoTiRepository.findByNomeLivroIgnoreCaseContaining(titulo).stream().map(AcervoTiResponseDTO::new).toList();
        return acervoList;
    }

    @GetMapping(params = "categoria")
    public List<AcervoTiResponseDTO> getBooksByCategoria(@RequestParam String categoria){
        List<AcervoTiResponseDTO> acervoList = acervoTiRepository.findByCategoria(categoria).stream().map(AcervoTiResponseDTO::new).toList();
        return acervoList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcervoTiResponseDTO> getBooksById(@PathVariable("id") UUID id){
        Optional<AcervoTiModel> acervoTiOptional = acervoTiRepository.findById(id);
        if (acervoTiOptional.isPresent()) {
            AcervoTiResponseDTO acervoTiResponseDTO = new AcervoTiResponseDTO(acervoTiOptional.get());
            return ResponseEntity.ok().body(acervoTiResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void postBooks(@RequestBody AcervoTiRequestDTO data){
        AcervoTiModel acervoData = new AcervoTiModel(data);
        acervoTiRepository.save(acervoData);
        return;
    }
}
