package ec.gob.turismo.convenios.controller;

import ec.gob.turismo.convenios.exception.CustomErrorResponse;
import ec.gob.turismo.convenios.model.User;
import ec.gob.turismo.convenios.security.JwtRequest;
import ec.gob.turismo.convenios.security.JwtResponse;
import ec.gob.turismo.convenios.security.JwtTokenUtil;
import ec.gob.turismo.convenios.security.JwtUserDetailsService;
import ec.gob.turismo.convenios.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

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

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {

//        int auth = service.authLDAP(req.getUsername(), req.getPassword());

//        if (auth == 0) {
//            CustomErrorResponse err = new CustomErrorResponse("", "", "");
//            throw new Exception("INVALID_CREDENTIALS");
//        }

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

   /* @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        authenticate(req.getUsername(), req.getPassword());

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }*/

}
