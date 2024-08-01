package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.projection.IAgreementProjection;
import ec.gob.turismo.convenios.model.Agreement;
import ec.gob.turismo.convenios.projection.IListAgreementProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface IAgreementRepo<T, ID> extends IGenericRepo<Agreement, UUID> {

    @Query("SELECT a as agreement " +
            "FROM Agreement a LEFT JOIN Administrator ad on a.id = ad.agreement.id  LEFT JOIN AgreementState st on a.id = st.agreement.id " +
            "WHERE a.origin.type = :type AND a.origin.code = :code " +
            "AND ad.enable = true AND st.enable = true ")
    List<Agreement> find(@Param("type") String type, @Param("code") String code);

    @Query("SELECT ad as administrator, st as agreementState, a as agreement " +
            "FROM Agreement a LEFT JOIN Administrator ad on a.id = ad.agreement.id  LEFT JOIN AgreementState st on a.id = st.agreement.id " +
            "WHERE a.origin.type = :type AND a.origin.code = :code " +
            "AND ad.enable = true AND st.enable = true ")
    List<IListAgreementProjection> findNationalAgreementsByOrigin(@Param("type") String type, @Param("code") String code);



}
