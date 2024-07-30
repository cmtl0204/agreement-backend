package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.dto.AdministratorDTO;
import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.model.*;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/agreement")
@RequiredArgsConstructor
public class AgreementController {

    private final IAgreementService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final MapperUtil mapperUtil;

 /*   @GetMapping
    public ResponseEntity<List<CatalogueDTO>> findAll() {
        List<CatalogueDTO> list = service.findCatalogue().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }*/

    @PostMapping
    public ResponseEntity<AgreementDTO> save(@Valid @RequestBody AgreementDTO dto) {
        Agreement agreement = mapperUtil.map(dto, Agreement.class);
        Agreement obj = service.createAgreement(agreement);

        return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
    }


    private AdministratorDTO convertToDto(AdministratorDTO obj) {
        return mapper.map(obj, AdministratorDTO.class);
    }

    private Administrator convertToEntity(AdministratorDTO dto) {
        return mapper.map(dto, Administrator.class);
    }


}
