package org.mon.iocanddi.ioc.controller;

import jakarta.annotation.Resource;
import org.mon.iocanddi.ioc.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@Controller
//@RestController
public class YmlController {


    @Autowired
    public StudentConfig studentConfig;


    @RequestMapping("/readObject")
    public String readObject(){
        return studentConfig.toString();
    }
}
