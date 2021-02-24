package com.codewithchang.restjpahibernate.controller;

import com.codewithchang.restjpahibernate.model.User;
import com.codewithchang.restjpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UserController {

    public static final int DEFAULT_SIZE = 30;

    @Autowired
    UserService service;

    @GetMapping("/users")
    public Object getUserPage(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        int _page = page != null ? page : 0;
        int _size = size != null ? size : 0;

        return service.findAll(_page, _size);
    }

    @PostMapping("/user")
    public Object postUser(
            @RequestBody User user
    ) {
        return service.save(user);
    }
}
