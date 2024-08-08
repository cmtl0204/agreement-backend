package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Catalogue;
import ec.gob.turismo.convenios.model.MyFile;
import ec.gob.turismo.convenios.model.Parameter;
import ec.gob.turismo.convenios.repo.IAgreementRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.repo.IMyFileRepo;
import ec.gob.turismo.convenios.repo.IParameterRepo;
import ec.gob.turismo.convenios.service.IMyFileService;
import ec.gob.turismo.convenios.util.ParameterEnum;
import ec.gob.turismo.convenios.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MyFileServiceImpl extends CRUDImpl<MyFile, UUID> implements IMyFileService {

    private final IMyFileRepo fileRepo;

    private final IParameterRepo parameterRepo;

    @Override
    protected IGenericRepo<MyFile, UUID> getRepo() {

        return fileRepo;
    }

    @Transactional
    @Override
    public MyFile createFile(UUID modelId, List<UUID> typeIds, List<MultipartFile> files) throws Exception {

        String pathRelative = "";
        Path path = null;
        Path absolute = null;
        Parameter uploadDirParam = null;
        String UPLOAD_FOLDER = "";
        String directory = parameterRepo.findParameterByName(ParameterEnum.FilePath.FILE_DIRECTORY.toString()).getValue();
        if (Util.isWindows()) {
            uploadDirParam = parameterRepo.findParameterByName(ParameterEnum.FilePath.UPLOAD_DIR_WINDOWS.toString());
            UPLOAD_FOLDER = uploadDirParam.getValue() + File.separator + File.separator + directory + File.separator + File.separator + modelId;
            Util.createFolderIfNotExists(UPLOAD_FOLDER);
            UPLOAD_FOLDER = UPLOAD_FOLDER + File.separator + File.separator;
            path = Paths.get(uploadDirParam.getValue() + File.separator + File.separator + directory);
        } else {
            uploadDirParam = parameterRepo.findParameterByName(ParameterEnum.FilePath.UPLOAD_DIR_LINUX.toString());
            UPLOAD_FOLDER = uploadDirParam.getValue() + File.separator + directory + File.separator + modelId;
            Util.createFolderIfNotExists(UPLOAD_FOLDER);
            UPLOAD_FOLDER = UPLOAD_FOLDER + File.separator;
            path = Paths.get(uploadDirParam.getValue() + File.separator + directory);

        }

        absolute = Paths.get(UPLOAD_FOLDER);
        pathRelative = String.valueOf(path.relativize(absolute));

        for (int i = 0; i < files.size(); i++) {
            File file = Util.convertToFile(files.get(i));
            Catalogue type = new Catalogue();
            type.setId(typeIds.get(i));

            String fileName = Util.slugify(file.getName());
            String extension = Util.extension(fileName);
            MyFile newFile = new MyFile();
            newFile.setModelId(modelId);
            newFile.setName(fileName);
            newFile.setExtension(extension);
            newFile.setPath(pathRelative);
            newFile.setSize(file.length());
            newFile.setType(type);
            fileRepo.save(newFile);

            String uploadedFileLocation = UPLOAD_FOLDER + newFile.getId() + "." + extension;
            File dest = new File(uploadedFileLocation);
            Util.copyFile(file, dest);
        }

        return new MyFile();
    }

    @Override
    public List<MyFile> findFilesByModel(UUID modelId) {
        return fileRepo.findMyFileByModelId(modelId);
    }

}
