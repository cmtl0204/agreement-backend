package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.Agreement;

import java.util.List;
import java.util.UUID;

public interface IAgreementService extends ICRUD<Agreement, UUID> {


    Agreement createAgreement(Agreement agreement);
    List<Agreement> findNationalAgreementsByOrigin();
    List<Agreement> find();

}
