package com.centralti.tdm.infra.security.USER;

import com.centralti.tdm.infra.security.DTO.AuthenticationDTO;
import com.centralti.tdm.infra.security.DTO.LoginResponseDTO;
import com.centralti.tdm.infra.security.DTO.RegisterDTO;
import com.centralti.tdm.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role(), data.name());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity<RegistersDTO> getUserByEmail() {
        String emailUsuario = SecurityContextHolder.getContext().getAuthentication().getName();

        User usuario = (User) repository.findByLogin(emailUsuario);

        if (usuario != null) {
            RegistersDTO usuarioDTO = new RegistersDTO(usuario);
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}