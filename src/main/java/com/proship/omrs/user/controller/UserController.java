package com.proship.omrs.user.controller;

import com.proship.omrs.base.controller.BaseController;
import com.proship.omrs.user.entity.NewUser;
import com.proship.omrs.user.entity.User;
import com.proship.omrs.user.service.UserService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j
@RestController
@RequestMapping(value="/user/")
@CrossOrigin
public class UserController extends BaseController<User,Long>{

    @Autowired
    public UserController(CrudRepository<User, Long> repo) {
        super(repo);
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method= RequestMethod.POST,consumes = {"application/json"})
    public ResponseEntity<User> register (@RequestBody User user){


        Logger logger = LoggerFactory.getLogger(this.getClass());



        user = userService.registerNewUser(user);


        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
