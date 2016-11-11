package com.tutal.ahmet.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

/**
 * Created by tutal on 10.11.2016.
 */

@Controller
public class LoginController implements Serializable {

    @RequestMapping(value = {"/", "/login"})
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(){
        return "redirect:todos";
    }

}
