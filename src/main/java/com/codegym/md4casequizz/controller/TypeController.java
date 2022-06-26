package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.model.Type;
import com.codegym.md4casequizz.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("types")
public class TypeController {
    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Iterable<Type>> listType() {
        Iterable<Type> types = typeService.findAll();
        if (types != null) {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
