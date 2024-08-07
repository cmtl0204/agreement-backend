package ec.gob.turismo.convenios.service;

import ec.gob.turismo.convenios.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService extends ICRUD<User, UUID> {


    List<User> findUserLDAP() throws Exception;

    User findUserByEmail(String email);

    int authLDAP(String username, String password) throws Exception;



}
