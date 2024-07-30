package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.*;

import java.util.List;
import java.util.UUID;

public interface IAgreementService extends ICRUD<Agreement, UUID> {


    Agreement createAgreement(Agreement agreement);

}
