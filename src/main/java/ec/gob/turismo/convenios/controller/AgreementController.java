package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.dto.AdministratorDTO;
import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.dto.ListAgreementDTO;
import ec.gob.turismo.convenios.model.*;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final IAgreementService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final MapperUtil mapperUtil;

    @GetMapping("/national_agreement")
    public ResponseEntity<List<ListAgreementDTO>> findNationalAgreementsByOrigin() {
        List<Agreement> listObj = service.findNationalAgreementsByOrigin();
        List<ListAgreementDTO> listDto = mapper.map(listObj, new TypeToken<List<ListAgreementDTO>>(){}.getType());

        return ResponseEntity.ok(listDto);
    }

    @GetMapping
    public ResponseEntity<List<ListAgreementDTO>> findAll() {
        List<Agreement> listObj = service.find();
        List<ListAgreementDTO> listDto = mapper.map(listObj, new TypeToken<List<ListAgreementDTO>>(){}.getType());

        return ResponseEntity.ok(listDto);
    }

    @PostMapping
    public ResponseEntity<AgreementDTO> save(@Valid @RequestBody AgreementDTO dto) {
        Agreement agreement = mapperUtil.map(dto, Agreement.class);
        Agreement obj = service.createAgreement(agreement);

        return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
    }

}
