package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.model.AgreementState;
import ec.gob.turismo.convenios.repo.IAdministratorRepo;
import ec.gob.turismo.convenios.repo.IAgreementStateRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.IAdministratorService;
import ec.gob.turismo.convenios.service.IAgreementStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementStateServiceImpl extends CRUDImpl<AgreementState, UUID> implements IAgreementStateService {

    private final IAgreementStateRepo repo;

    @Override
    protected IGenericRepo<AgreementState, UUID> getRepo() {

        return repo;
    }

}
