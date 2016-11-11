package com.tutal.ahmet.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * Created by tutal on 11.11.2016.
 */

@Controller
public class TodosController implements Serializable {

    @RequestMapping("/todos")
    public String todos() {
        return "todos";
    }

}
