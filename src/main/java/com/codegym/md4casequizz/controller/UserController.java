package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.service.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("users")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<User> user=userService.findById(id);
        if (!user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(user.get().getId());
        return new ResponseEntity<>(new ResponMessage("delete success"),HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<Iterable<User>> showListUser(){
        return new ResponseEntity<>(userService.showList(),HttpStatus.OK);
    }
}

