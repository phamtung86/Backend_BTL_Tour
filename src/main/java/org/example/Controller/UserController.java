package org.example.Controller;

import org.example.DTO.UserDTO;
import org.example.Modal.Users;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ListAllUser")
    @ResponseBody
    public ArrayList<Users> getUsers() {
        return userService.getAllUSer();
    }

}
