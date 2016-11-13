package com.tutal.ahmet.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
public class TodosController implements Serializable {

    @RequestMapping("/todos")
    public String todos() {
        return "todos";
    }

}
