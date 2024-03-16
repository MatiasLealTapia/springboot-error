package com.matias.udemy.curso.springboot.error.springbooterror.controllers;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.udemy.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.matias.udemy.curso.springboot.error.springbooterror.models.domain.User;
import com.matias.udemy.curso.springboot.error.springbooterror.services.IUserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        // 1ra OPCION:
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe."));
        // 2da OPCION:
        // User user = service.findById(id);
        // if (user == null) {
        //     throw new UserNotFoundException("Error el usuario no existe.");
        // }
        // 3ra OPCION:
        // Optional<User> optionalUser = service.findById(id);
        // if (optionalUser.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        // return ResponseEntity.ok(optionalUser.get());
        System.out.println(user.getLastname());
        return user;
    }
}
