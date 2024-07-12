package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Catalogue;
import ec.gob.turismo.convenios.repo.ICatalogueRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.ICatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogueServiceImpl extends CRUDImpl<Catalogue, UUID> implements ICatalogueService {

    private final ICatalogueRepo repo;

    @Override
    protected IGenericRepo<Catalogue, UUID> getRepo() {

        return repo;
    }


    @Override
    public List<Catalogue> findCatalogueChildless() {
        return repo.findCatalogueChildless();
    }
}
