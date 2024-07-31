package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.model.Agreement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface IAgreementRepo<T, ID> extends IGenericRepo<Agreement, UUID> {

    @Query("FROM Agreement a, Administrator ad, AgreementState st WHERE a.origin.type = :type AND a.origin.code = :code AND ad.enable = true AND st.enable = true")
    List<Agreement> findNationalAgreementsByOrigin(@Param("type") String type, @Param("code") String code);

    @Query("FROM Agreement a WHERE a.origin.type = :type AND a.origin.code = :code ")
    List<Agreement> find(@Param("type") String type, @Param("code") String code);

}
