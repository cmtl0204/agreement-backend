package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.*;
import ec.gob.turismo.convenios.repo.*;
import ec.gob.turismo.convenios.service.IAgreementService;
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

//    protected IGenericRepo<Administrator, UUID> getRepo() {
//
//        return administratorRepo;
//    }
//
//    protected IGenericRepo<InternalInstitution, UUID> getRepo() {
//
//        return internalInstitutionRepo;
//    }
//
//    protected IGenericRepo<ExternalInstitution, UUID> getRepo() {
//
//        return externalInstitutionRepo;
//    }

    @Transactional
    @Override
    public Agreement createAgreement(Agreement agreement, Administrator administrator,
                                     AgreementState agreementState,
                                     List<InternalInstitution> internalInstitutions,
                                     List<ExternalInstitution> externalInstitutions) {
        //agreement.setInternalInstitutions(new ArrayList<>());
        agreement.setExternalInstitutions(new ArrayList<>());

        agreementRepo.save(agreement);

//        administrator.setAgreement(agreement);
//
//        administratorRepo.save(administrator);
//
//        agreementState.setAgreement(agreement);
//
//        agreementStateRepo.save(agreementState);

//        internalInstitutions.forEach(internal -> {
//            internal.setAgreement(agreement);
//            internalInstitutionRepo.save(internal);
//        });

//        externalInstitutions.forEach(external -> {
//            external.setAgreement(agreement);
//            externalInstitutionRepo.save(external);
//        });
        return agreement;
    }


}
