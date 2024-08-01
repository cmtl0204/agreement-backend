package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.model.*;
import ec.gob.turismo.convenios.projection.IListAgreementProjection;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final IAgreementService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final MapperUtil mapperUtil;

    @GetMapping("/national_agreement")
    public ResponseEntity<List<IListAgreementProjection>> findNationalAgreementsByOrigin() {
       return ResponseEntity.ok(service.findNationalAgreementsByOrigin());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgreementDTO> findById(@PathVariable("id") UUID id) {
        Agreement obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<Agreement>> findAll() {
        //List<Agreement> listObj = service.find();
        //List<ListAgreementDTO> listDto = mapper.map(listObj, new TypeToken<List<ListAgreementDTO>>(){}.getType());
//        List<IAgreementDTO> listDto = service.find();

        return ResponseEntity.ok(service.find());
    }

    @PostMapping
    public ResponseEntity<AgreementDTO> save(@Valid @RequestBody AgreementDTO dto) {
        Agreement agreement = mapperUtil.map(dto, Agreement.class);
        Agreement obj = service.createAgreement(agreement);

        return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
    }

}
