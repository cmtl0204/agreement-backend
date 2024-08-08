package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.config.ResponseResult;
import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.projection.IAgreementProjection;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final IAgreementService service;

    private final MapperUtil mapperUtil;

    @CrossOrigin(origins = "*")
    @GetMapping("/national-agreements")
    //public ResponseEntity<List<IAgreementProjection>> findNationalAgreementsByOrigin() {
    public ResponseEntity<ResponseResult<List<IAgreementProjection>>> findNationalAgreementsByOrigin() {

//       return ResponseEntity.ok(service.findNationalAgreementsByOrigin());
        ResponseResult<List<IAgreementProjection>> resul = ResponseResult.success( service.findNationalAgreementsByOrigin());
        return ResponseEntity.ok(resul);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<AgreementDTO> findById(@PathVariable("id") UUID id) {
        Agreement obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Agreement>> findAll() {

        return ResponseEntity.ok(service.find());
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    //public ResponseEntity<AgreementDTO> save(@Valid @RequestBody AgreementDTO dto) {
    public ResponseEntity<ResponseResult<AgreementDTO>> save(@Valid @RequestBody AgreementDTO dto) {
        Agreement agreement = mapperUtil.map(dto, Agreement.class);
        Agreement obj = service.createAgreement(agreement);

        //return ResponseEntity.ok(mapperUtil.map(obj, AgreementDTO.class));
        ResponseResult<AgreementDTO> resul = ResponseResult.success(mapperUtil.map(obj, AgreementDTO.class));
        return ResponseEntity.ok(resul);
    }



}
