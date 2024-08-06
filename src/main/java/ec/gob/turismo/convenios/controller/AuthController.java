package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.model.User;
import ec.gob.turismo.convenios.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/ldap")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = null;
        try {
            list = service.findUserLDAP();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(list);
    }




}
