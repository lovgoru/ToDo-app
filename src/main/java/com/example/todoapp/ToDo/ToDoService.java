package com.example.todoapp.ToDo;

import com.example.todoapp.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public Long getUserId(Principal principal){ //pomocna funkcija koja vraca ID trenutno prijavljenog usera
        SecurityContext context= SecurityContextHolder.getContext();
        Authentication authentication=context.getAuthentication();
        return ((CustomUserDetails)authentication.getPrincipal()).getId();
    }

    public List<ToDo> getToDo(Principal principal) {
        return toDoRepository.findUserToDos(getUserId(principal));
    }

    public void saveToDo(ToDo toDo, Principal principal) {
        toDo.setUserId(getUserId(principal));
        toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
