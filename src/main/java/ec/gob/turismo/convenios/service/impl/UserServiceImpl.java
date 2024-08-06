package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.User;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.repo.IUserRepo;
import ec.gob.turismo.convenios.service.IUserService;
import ec.gob.turismo.convenios.util.LDAP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, UUID> implements IUserService {

    private final IUserRepo userRepo;

    @Override
    protected IGenericRepo<User, UUID> getRepo() {

        return userRepo;
    }

    @Override
    public List<User> findUserLDAP() throws Exception {
         new ArrayList<User>();
        LDAP ldap = new LDAP();
        return ldap.buscarUsuariosLdap();
    }
}
