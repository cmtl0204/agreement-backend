package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.config.ResponseResult;
import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.dto.MyFileDTO;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.model.MyFile;
import ec.gob.turismo.convenios.service.IMyFileService;
import ec.gob.turismo.convenios.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class MyFileController {

    private final IMyFileService service;

    private final MapperUtil mapperUtil;

    @PostMapping(value = "models/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MyFileDTO> saveFile(
            @PathVariable("id") UUID modelId,
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("typeId") UUID typeId) throws Exception {

        MyFile obj = service.createFile(modelId, typeId, files);

        return ResponseEntity.ok(mapperUtil.map(obj, MyFileDTO.class));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("models/{id}")
    public ResponseEntity<ResponseResult<List<MyFileDTO>>> findById(@PathVariable("id") UUID id) {
        List<MyFile> obj = service.findFilesByModel(id);
        List<MyFileDTO> dto = mapperUtil.mapList(obj, MyFileDTO.class);
        ResponseResult<List<MyFileDTO>> list = ResponseResult.success(dto);

        return ResponseEntity.ok(list);
    }



}
