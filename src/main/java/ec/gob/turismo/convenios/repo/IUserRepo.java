package ec.gob.turismo.convenios.repo;

import ec.gob.turismo.convenios.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface IUserRepo<T, ID> extends IGenericRepo<User, UUID> {

    @Query("FROM User u WHERE u.username = :username AND u.enabled")
    User findOneByUsername(String username);

    @Query("FROM User u WHERE u.email = :email AND u.enabled")
    User findUserByEmail(@Param("email") String email);


}
