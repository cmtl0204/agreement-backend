package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.model.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


public interface IParameterRepo<T, ID> extends IGenericRepo<Parameter, UUID> {

    @Query("FROM Parameter p WHERE p.name = :name")
    Parameter findParameterByName(@Param("name") String name);


}
