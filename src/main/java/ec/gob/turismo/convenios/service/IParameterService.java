package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.Parameter;

import java.util.UUID;

public interface IParameterService extends ICRUD<Parameter, UUID> {


    Parameter findParameterByName(String name);



}
