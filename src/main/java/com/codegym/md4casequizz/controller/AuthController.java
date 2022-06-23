package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.request.SignInForm;
import com.codegym.md4casequizz.dto.request.SignUpForm;
import com.codegym.md4casequizz.dto.response.JwtResponse;
import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Role;
import com.codegym.md4casequizz.model.RoleName;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.security.jwt.JwtProvider;
import com.codegym.md4casequizz.security.userprincal.UserPrinciple;
import com.codegym.md4casequizz.service.role.RoleServiceImpl;
import com.codegym.md4casequizz.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
@CrossOrigin("*")
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
        if (userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponMessage("no_user"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponMessage("no_email"),HttpStatus.OK);
        }

        if(signUpForm.getAvatar() == null || signUpForm.getAvatar().trim().isEmpty()){
            signUpForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/blog-eab4c.appspot.com/o/images%2Fth.jpg?alt=media&token=ab0cfde1-be53-49e3-a686-ea86b4ad2cde");
        }
        User user=new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getAvatar(), passwordEncoder.encode(signUpForm.getPassword()) );
        Set<String> strRoles=signUpForm.getRoles();
        Set<Role> roles=new HashSet<>();
        strRoles.forEach(role ->{
            switch (role){
                case "admin":
                        Role adminRole=roleService.findByName(RoleName.ADMIN).orElseThrow(
                                ()->new RuntimeException("Role not found")
                        );
                roles.add(adminRole);
                break;
                case "pm":
                   Role pmRole=roleService.findByName(RoleName.PM).orElseThrow(
                           ()->new RuntimeException("Role not found"));
                   roles.add(pmRole);
                   break;
                default:
                    Role userRole=roleService.findByName(RoleName.USER).orElseThrow(
                            ()->new RuntimeException("Role not found"));
                    roles.add(userRole);

            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponMessage("Create User Account Success!"),HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(),signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
return  ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(),userPrinciple.getAvatar(),
        userPrinciple.getAuthorities()));


    }
}
