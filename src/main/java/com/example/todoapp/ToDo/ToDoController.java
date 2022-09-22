package com.example.todoapp.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String homeScreen(){
        return "index";
    }

    @GetMapping("/home")
    public String homeScreenLogged(){
        return "homeScreenLogged";
    }

    @GetMapping("/list-of-todos")
    public String getToDo(Model model, Principal principal){
        List<ToDo> ToDos = toDoService.getToDo(principal);
        model.addAttribute("ToDos", ToDos);
        return "ToDoList";
    }

    @GetMapping("/add-todo")
    public String addToDo(){
        return "AddToDo";
    }

    @PostMapping("/list-of-todos")
    public String saveToDo(ToDo toDo, Principal principal){
        toDoService.saveToDo(toDo, principal);
        return "redirect:/list-of-todos";
    }

    //Anotacija @DeleteMapping nece funkcionirati u ovom slucaju
    @RequestMapping(value = "/list-of-todos/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
        return "redirect:/list-of-todos";
    }
}
