package com.example.todoapp.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

    @Query(value = "SELECT * FROM to_do WHERE user_id = ?1 ORDER BY date", nativeQuery = true)
    List<ToDo> findUserToDos(Long id);


}
