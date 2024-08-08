package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.model.MyFile;
import ec.gob.turismo.convenios.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;


public interface IMyFileRepo<T, ID> extends IGenericRepo<MyFile, UUID> {

    @Query("FROM MyFile f WHERE f.modelId = :modelId AND f.enabled")
    List<MyFile> findMyFileByModelId(UUID modelId);



}
