package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.*;
import ec.gob.turismo.convenios.repo.*;
import ec.gob.turismo.convenios.service.IAgreementService;
import ec.gob.turismo.convenios.util.CatalogueEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl extends CRUDImpl<Agreement, UUID> implements IAgreementService {

    private final IAgreementRepo agreementRepo;
    private final IAdministratorRepo administratorRepo;
    private final IAgreementStateRepo agreementStateRepo;
    private final IInternalInstitutionRepo internalInstitutionRepo;
    private final IExternalInstitutionRepo externalInstitutionRepo;
    private final AdministratorServiceImpl administratorServiceImpl;

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
    public List<Agreement> findNationalAgreementsByOrigin() {
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
