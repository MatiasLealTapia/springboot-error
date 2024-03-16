package com.matias.udemy.curso.springboot.error.springbooterror.services;

import java.util.List;
import java.util.Optional;

import com.matias.udemy.curso.springboot.error.springbooterror.models.domain.User;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
