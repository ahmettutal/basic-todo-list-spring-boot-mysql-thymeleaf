package com.tutal.ahmet.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by tutal on 11.11.2016.
 */

@Controller
public class LogutController implements Serializable {

    @RequestMapping(value = "/logout")
    public String logout() {
        throw new RuntimeException("This is a simulated error message2");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@RequestParam(value = "email") String email){
        return "login";
    }

}
