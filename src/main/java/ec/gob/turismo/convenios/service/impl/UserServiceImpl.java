package ec.gob.turismo.convenios.service.impl;

import ec.gob.turismo.convenios.model.Parameter;
import ec.gob.turismo.convenios.model.User;
import ec.gob.turismo.convenios.repo.IGenericRepo;
import ec.gob.turismo.convenios.repo.IParameterRepo;
import ec.gob.turismo.convenios.repo.IUserRepo;
import ec.gob.turismo.convenios.service.IUserService;
import ec.gob.turismo.convenios.util.LDAP;
import ec.gob.turismo.convenios.util.ParameterEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, UUID> implements IUserService {

    private final IUserRepo userRepo;
    private final IParameterRepo parameterRepo;


    @Override
    protected IGenericRepo<User, UUID> getRepo() {

        return userRepo;
    }

//    private final Parameter connectionLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_CONNECTION.toString());
//    private final Parameter dnLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_DN.toString());
//    private final Parameter findLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_FIND.toString());
//    private final Parameter passLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_PASS.toString());

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public List<User> findUserLDAP() throws Exception {

        Parameter connectionLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_CONNECTION.toString());
        Parameter dnLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_DN.toString());
        Parameter findLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_FIND.toString());
        Parameter passLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_PASS.toString());
        LDAP ldap = new LDAP();

        return ldap.findUserLDAP(connectionLdap.getValue(), dnLdap.getValue(), findLdap.getValue(), passLdap.getValue());
    }

    @Override
    public int authLDAP(String username, String password) throws Exception {
        Parameter connectionLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_CONNECTION.toString());
        Parameter dnLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_DN.toString());
        Parameter findLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_FIND.toString());
        Parameter passLdap = parameterRepo.findParameterByName(ParameterEnum.Ldap.LDAP_PASS.toString());
        LDAP ldap = new LDAP();
        return ldap.validationAuth(connectionLdap.getValue(), dnLdap.getValue(),username,password);
    }
}
