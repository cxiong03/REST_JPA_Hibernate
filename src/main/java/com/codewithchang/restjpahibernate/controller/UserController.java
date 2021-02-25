package com.codewithchang.restjpahibernate.controller;

import com.codewithchang.restjpahibernate.model.User;
import com.codewithchang.restjpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class UserController {

    public static final int DEFAULT_SIZE = 30;

    @Autowired
    UserService service;

    @GetMapping("/users")
    public Object getUserPage(
            @RequestParam(/*required = false*/defaultValue = "0") Integer page,
            @RequestParam(/*required = false*/defaultValue = "30") Integer size
    ) {
//        int _page = page != null ? page : 0;
//        int _size = size != null ? size : DEFAULT_SIZE;

        Page<User> getpage = service.findAll(page, size);

        Map<String, Object> map = new HashMap<>();
        map.put("content", getpage.getContent());
        map.put("page", page);
        map.put("size", size);
        map.put("totalPages", getpage.getTotalPages());
        map.put("totalItems", getpage.getTotalElements());

        return map;
    }

    @PostMapping("/user")
    public Object postUser(
            @RequestBody User user
    ) {
        return service.save(user);
    }
}
