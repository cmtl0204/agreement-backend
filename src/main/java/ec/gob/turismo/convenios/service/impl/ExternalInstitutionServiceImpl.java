package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.ExternalInstitution;
import ec.gob.turismo.convenios.repo.IExternalInstitutionRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.IExternalInstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExternalInstitutionServiceImpl extends CRUDImpl<ExternalInstitution, UUID> implements IExternalInstitutionService {

    private final IExternalInstitutionRepo repo;

    @Override
    protected IGenericRepo<ExternalInstitution, UUID> getRepo() {

        return repo;
    }

}
