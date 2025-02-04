package org.mon.mybaits.demo.controller;


import org.mon.mybaits.demo.model.UserInfo;
import org.mon.mybaits.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectUserList")
    public List<UserInfo> selectUserList(){
        return userService.selectUserList();
    }
}
