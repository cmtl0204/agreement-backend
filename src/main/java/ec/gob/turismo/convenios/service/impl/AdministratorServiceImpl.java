package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.repo.IAdministratorRepo;
import ec.gob.turismo.convenios.repo.IAgreementRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.IAdministratorService;
import ec.gob.turismo.convenios.service.IAgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl extends CRUDImpl<Administrator, UUID> implements IAdministratorService {

    private final IAdministratorRepo repo;

    @Override
    protected IGenericRepo<Administrator, UUID> getRepo() {

        return repo;
    }

}
