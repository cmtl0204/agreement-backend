package ec.gob.turismo.convenios.controller;

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
        List<InternalInstitution> internal = mapper.map(dto.getInternalInstitutions(), new TypeToken<List<InternalInstitution>>(){}.getType());
        List<ExternalInstitution> external = mapper.map(dto.getExternalInstitutions(), new TypeToken<List<ExternalInstitution>>(){}.getType());
        Agreement obj = service.createAgreement(mapperUtil.map(dto, Agreement.class, "defaultMapper"),
                mapperUtil.map(dto.getAdministrator(), Administrator.class, "defaultMapper"),
                mapperUtil.map(dto.getAgreementState(), AgreementState.class, "defaultMapper"),
                internal,
                external);
        Agreement agreement = service.findById(obj.getId());
        System.out.println(agreement.toString());
        return ResponseEntity.ok(mapperUtil.map(agreement, AgreementDTO.class,"defaultMapper"));
    }


   /* private CatalogueDTO convertToDto(Catalogue obj) {
        return mapper.map(obj, CatalogueDTO.class);
    }

    private Catalogue convertToEntity(CatalogueDTO dto) {

        return mapper.map(dto, Catalogue.class);
    }*/


}
