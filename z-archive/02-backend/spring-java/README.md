# Java Spring Basics

Spring init: jpa, mysql driver, postgresql, web
lombok, devtools - needs configuration

**application.properties**
d
```application.properties
spring.jpa.hibernate.ddl-auto=update # update - creates table, none - does not

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.driver-class-name=com.mysql.jdbc.Driver # maybe not needed

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.driver-class-name=org.postgresql.Driver

spring.datasource.username=root
spring.datasource.password=

spring.jpa.show-sql=true
```

**Entity POJO Class**
Can automatically create tables
```java
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity (name = "todo") // name is table name
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "todo_title")
    private String title;
    // create empty, all args constructor, getters, setters
}
```

**Repository Interface (unsure what it does / just java stuff)**

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> { }
```

**Rest Controller**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    String hello() { return "Hello There";  }

    @GetMapping("/all")
    List<Person> getPeople() {
        return personRepository.findAll();
    }

    public String getFoos(@RequestParam(name = "id") String id) {
       return "ID: " + id;
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoService.updateTodoById(id, todo);
    }
}
```

**Service interface (not necessary, directly inject repo into controller)**

```java
public interface TodoService {
    Todo saveTodo(Todo todo);

    List<Todo> fetchAllTodo();

    Todo getTodoById(int id);

    Todo updateTodoById(int id, Todo todo);

    String deleteTodoById(int id);
}
```

**Service Implementation**
```java
@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> fetchAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.isPresent() ? todo.get() : null;
    }

    @Override
    public Todo updateTodoById(int id, Todo newTodo) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            Todo originalTodo = todo.get();

            if (Objects.nonNull(newTodo.getTitle()) && !"".equalsIgnoreCase(newTodo.getTitle())) {
                originalTodo.setTitle(newTodo.getTitle());
            }

            return todoRepository.save(originalTodo);
        }
        return null;
    }

    @Override
    public String deleteTodoById(int id) {
        if (todoRepository.findById(id).isPresent()) {
            todoRepository.deleteById(id);
            return "Todo Deleted";
        }
        return "Todo doesn't exist";
    }
}

```