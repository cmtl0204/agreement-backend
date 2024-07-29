package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.model.InternalInstitution;
import ec.gob.turismo.convenios.repo.IAdministratorRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.repo.IInternalInstitutionRepo;
import ec.gob.turismo.convenios.service.IAdministratorService;
import ec.gob.turismo.convenios.service.IInternalInstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InternalInstitutionServiceImpl extends CRUDImpl<InternalInstitution, UUID> implements IInternalInstitutionService {

    private final IInternalInstitutionRepo repo;

    @Override
    protected IGenericRepo<InternalInstitution, UUID> getRepo() {

        return repo;
    }

}
