package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.dto.CatalogueDTO;
import ec.gob.turismo.convenios.model.Catalogue;
import ec.gob.turismo.convenios.service.ICatalogueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/catalogues")
@RequiredArgsConstructor
public class CatalogueController {

    private final ICatalogueService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CatalogueDTO>> findAll() {
        List<CatalogueDTO> list = service.findCatalogueChildless().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    private CatalogueDTO convertToDto(Catalogue obj) {
        return mapper.map(obj, CatalogueDTO.class);
    }

    private Catalogue convertToEntity(CatalogueDTO dto) {

        return mapper.map(dto, Catalogue.class);
    }


}
