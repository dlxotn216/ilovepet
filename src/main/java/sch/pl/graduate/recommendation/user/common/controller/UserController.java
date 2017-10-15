package sch.pl.graduate.recommendation.user.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sch.pl.graduate.recommendation.common.controller.AbstractController;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.service.UserService;

/**
 * Created by taesu on 2017-10-14.
 */
@RestController
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        Integer result = userService.addUser(user);

        return getSuccessResponse(result, "성공하였습니다");
    }
}
