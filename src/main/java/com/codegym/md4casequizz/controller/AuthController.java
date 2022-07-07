package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.request.*;
import com.codegym.md4casequizz.dto.response.JwtResponse;
import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Role;
import com.codegym.md4casequizz.model.RoleName;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.security.jwt.JwtProvider;
import com.codegym.md4casequizz.security.jwt.JwtTokenFilter;
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping("")
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
    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponMessage("no_user"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponMessage("no_email"), HttpStatus.OK);
        }

        if (signUpForm.getAvatar() == null || signUpForm.getAvatar().trim().isEmpty()) {
            signUpForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/blog-eab4c.appspot.com/o/images%2Fth%20(1).jpg?alt=media&token=aff3ee5b-f7c2-419a-98bb-9dd3e48041bd");
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getAvatar(), passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                        Role adminRole=roleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(
                                ()->new RuntimeException("Role not found")
                        );
                roles.add(adminRole);
                break;
                default:
                    Role userRole=roleService.findByName(RoleName.ROLE_USER).orElseThrow(
                            ()->new RuntimeException("Role not found"));
                    roles.add(userRole);

            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponMessage("Create User Account Success!"), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token,userPrinciple.getId(), userPrinciple.getName(), userPrinciple.getUsername(),userPrinciple.getEmail(), userPrinciple.getAvatar(), userPrinciple.getAuthorities()));
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @Valid @RequestBody ChangePasswordForm changePasswordForm){
        String jwt = jwtTokenFilter.getJwt(request);
        String username = jwtProvider.getUserNameToken(jwt);
        User user;
        try {
            user = userService.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found with -> username"+username));
            boolean matches = passwordEncoder.matches(changePasswordForm.getCurrentPassword(), user.getPassword());
            if(changePasswordForm.getNewPassword() != null){
                if(matches){
                    user.setPassword(passwordEncoder.encode(changePasswordForm.getNewPassword()));
                    userService.save(user);
                } else {
                    return new ResponseEntity<>(new ResponMessage("Can't change password"), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(new ResponMessage("Changed password"), HttpStatus.OK);
        } catch (UsernameNotFoundException exception){
            return new ResponseEntity<>(new ResponMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/change-avatar")
    public ResponseEntity<?> changeAvatar(HttpServletRequest request, @Valid @RequestBody ChangeAvatar changeAvatar){
        String jwt=jwtTokenFilter.getJwt(request);
        String username=jwtProvider.getUserNameToken(jwt);
   User user;
           try{
                if (changeAvatar.getAvatar()==null){
                    return new ResponseEntity<>(new ResponMessage("no avatar"),HttpStatus.OK);
                }else {
                    user=userService.findByUsername(username).orElseThrow(()->
                            new UsernameNotFoundException("Username not found -> username"+username));
               user.setAvatar(changeAvatar.getAvatar());
               userService.save(user);
                }
               return new ResponseEntity<>(new ResponMessage("success"),HttpStatus.OK);

           }catch (UsernameNotFoundException exception){
               return new ResponseEntity<>(new ResponMessage(exception.getMessage()),HttpStatus.NOT_FOUND);
           }
    }
    @PutMapping("/change-profile")
    public ResponseEntity<?> changeProfile(HttpServletRequest request, @Valid @RequestBody ChangeProfileForm changeProfileForm){
        String jwt=jwtTokenFilter.getJwt(request);
        String username=jwtProvider.getUserNameToken(jwt);
        User user;
        try {
            if (userService.existsByUsername(changeProfileForm.getUsername())){
                return new ResponseEntity<>(new ResponMessage("no user"),HttpStatus.OK);
            }
            if (userService.existsByEmail(changeProfileForm.getEmail())){
                return new ResponseEntity<>(new ResponMessage("no email"),HttpStatus.OK);

            }
            user=userService.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found with -> username"+username));
            user.setName(changeProfileForm.getName());
            user.setUsername(changeProfileForm.getUsername());
            user.setEmail(changeProfileForm.getEmail());
            userService.save(user);
            return new ResponseEntity<>(new ResponMessage("success!!!!!!"),HttpStatus.OK);

        }catch (UsernameNotFoundException exception){
            return new ResponseEntity<>(new ResponMessage(exception.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

}
