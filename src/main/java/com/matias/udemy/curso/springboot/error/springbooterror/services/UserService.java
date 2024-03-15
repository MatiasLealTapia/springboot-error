package com.matias.udemy.curso.springboot.error.springbooterror.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matias.udemy.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserService implements IUserService {

    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez"));
        users.add(new User(1L, "Andrés", "Mena"));
        users.add(new User(1L, "María", "Perez"));
        users.add(new User(1L, "Josefa", "Ramirez"));
        users.add(new User(1L, "Ale", "Gutierrez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        return user;
    }

}
