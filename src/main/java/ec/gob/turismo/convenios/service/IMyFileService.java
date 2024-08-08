package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.MyFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IMyFileService extends ICRUD<MyFile, UUID> {


    MyFile createFile(UUID modelId, UUID typeId, List<MultipartFile> files) throws Exception;
    List<MyFile> findFilesByModel(UUID modelId);


}
