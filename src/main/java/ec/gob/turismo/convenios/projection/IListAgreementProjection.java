package ec.gob.turismo.convenios.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IListAgreementProjection {

    IAgreementProjection getAgreement();
    IAdministratorProjection getAdministrator();
    IAgreementStateProjection getAgreementState();
}
