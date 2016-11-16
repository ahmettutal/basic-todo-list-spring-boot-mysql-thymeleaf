package com.tutal.ahmet.springboot.controller;

import com.tutal.ahmet.springboot.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
@RequestMapping("/todos")
public class TodosController implements Serializable {

    @Autowired
    TodosService todosService;

    @RequestMapping(method = RequestMethod.GET)
    public String todos(Model model) {

        todosService.findByCompletedAndUserId(model);

        return "todos";
    }

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String addTodos(@PathVariable("name") String name) {

        todosService.addTodos(name);

        return "200 OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
    public String updateComplated(@PathVariable("name") String name) {

        todosService.updateComplated(name);

        return "200 OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteTodos(@PathVariable("name") String name) {

        todosService.deleteTodos(name);

        return "200 OK";
    }

}
