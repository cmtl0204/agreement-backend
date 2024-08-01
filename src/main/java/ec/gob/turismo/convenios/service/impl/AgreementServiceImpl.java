package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.projection.IAgreementProjection;
import ec.gob.turismo.convenios.model.Administrator;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.model.AgreementState;
import ec.gob.turismo.convenios.projection.IListAgreementProjection;
import ec.gob.turismo.convenios.repo.IAdministratorRepo;
import ec.gob.turismo.convenios.repo.IAgreementRepo;
import ec.gob.turismo.convenios.repo.IAgreementStateRepo;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.CatalogueEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl extends CRUDImpl<Agreement, UUID> implements IAgreementService {

    private final IAgreementRepo agreementRepo;
    private final IAdministratorRepo administratorRepo;
    private final IAgreementStateRepo agreementStateRepo;

    @Override
    protected IGenericRepo<Agreement, UUID> getRepo() {

        return agreementRepo;
    }

    @Transactional
    @Override
    public Agreement createAgreement(Agreement agreement) {

        agreementRepo.save(agreement);

        Administrator administrator = agreement.getAdministrator();
        administrator.setAgreement(agreement);
        administratorRepo.save(administrator);

        AgreementState agreementState = agreement.getAgreementState();
        agreementState.setAgreement(agreement);
        agreementStateRepo.save(agreementState);

        return agreement;
    }

    @Override
    public List<IListAgreementProjection> findNationalAgreementsByOrigin() {
        String type = CatalogueEnum.CatalogueType.AGREEMENTS_ORIGIN.toString();
        String code = CatalogueEnum.AgreementOrigin.NATIONAL.toString();
        return agreementRepo.findNationalAgreementsByOrigin(type, code);
    }

    @Override
    public List<Agreement> find() {
        String type = CatalogueEnum.CatalogueType.AGREEMENTS_ORIGIN.toString();
        String code = CatalogueEnum.AgreementOrigin.NATIONAL.toString();
        return agreementRepo.find(type, code);
    }

}
