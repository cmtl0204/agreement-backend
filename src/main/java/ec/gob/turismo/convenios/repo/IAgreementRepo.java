package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.dto.AgreementDTO;
import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.model.AgreementState;

import java.util.List;
import java.util.UUID;


public interface IAgreementRepo<T, ID> extends IGenericRepo<Agreement, UUID> {


}
