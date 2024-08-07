package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Parameter;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.repo.IParameterRepo;
import ec.gob.turismo.convenios.service.IParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParameterServiceImpl extends CRUDImpl<Parameter, UUID> implements IParameterService {

    private final IParameterRepo parameterRepo;

    @Override
    protected IGenericRepo<Parameter, UUID> getRepo() {

        return parameterRepo;
    }

    @Override
    public Parameter findParameterByName(String name) {
        return parameterRepo.findParameterByName(name);
    }

}
