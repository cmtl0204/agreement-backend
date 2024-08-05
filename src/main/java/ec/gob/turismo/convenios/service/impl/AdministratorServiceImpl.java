package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.repo.IAdministratorRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.IAdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
