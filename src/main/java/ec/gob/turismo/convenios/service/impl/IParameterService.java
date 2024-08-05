package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.MyFile;
import ec.gob.turismo.convenios.model.Parameter;
import ec.gob.turismo.convenios.service.ICRUD;

import java.io.File;
import java.util.UUID;

public interface IParameterService extends ICRUD<Parameter, UUID> {


    Parameter findParameterByName(String name);



}
