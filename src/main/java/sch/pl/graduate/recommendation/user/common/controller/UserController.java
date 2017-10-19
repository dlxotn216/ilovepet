package sch.pl.graduate.recommendation.user.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.service.UserService;

import java.rmi.activation.ActivationGroup_Stub;

/**
 * Created by taesu on 2017-10-14.
 */
@RestController
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        Long result = userService.addUser(user);

        return getSuccessResponse(result, "성공하였습니다");
    }

    @PutMapping("/users/{userKey}")
    public ResponseEntity updateUser(@PathVariable Long userKey, @RequestBody User user){
        user.setUserKey(userKey);
        Integer result = userService.updateUser(user);

        return getSuccessResponse(result, "성공하였습니다");
    }
}
