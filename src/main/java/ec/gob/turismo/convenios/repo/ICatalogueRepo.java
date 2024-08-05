package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.model.Catalogue;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;


public interface ICatalogueRepo<T, ID> extends IGenericRepo<Catalogue, UUID> {

    @Query("FROM Catalogue c ORDER BY c.type, c.sort")
    List<Catalogue> findCatalogue();
}
