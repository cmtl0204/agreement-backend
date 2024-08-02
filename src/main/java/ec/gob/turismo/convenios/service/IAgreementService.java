package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.projection.IAgreementProjection;

import java.util.List;
import java.util.UUID;

public interface IAgreementService extends ICRUD<Agreement, UUID> {


    Agreement createAgreement(Agreement agreement);
    List<Agreement> find();
    List<IAgreementProjection> findNationalAgreementsByOrigin();


}
