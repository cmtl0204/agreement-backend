package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.Catalogue;

import java.util.List;
import java.util.UUID;

public interface ICatalogueService extends ICRUD<Catalogue, UUID> {

    List<Catalogue> findCatalogue();

}
