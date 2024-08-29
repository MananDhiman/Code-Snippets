# Java Spring Basics

Spring init: jpa, mysql driver, web

**application.properties**

```application.properties
spring.application.name=mysql_crud
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.show-sql=true
```

**Entity POJO Class**

```java
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    // create constructor, empty constructor, getters, setters
}
```

**Repository Interface (unsure what it does / just java stuff)**

```java
public interface TodoRepository extends JpaRepository<Todo, Integer> { }
```

**Service interface**

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

**Rest Controller**

```java
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public Todo saveTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @GetMapping("/todo")
    public List<Todo> getAllTodos() {
        return todoService.fetchAllTodo();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoService.updateTodoById(id, todo);
    }

    @DeleteMapping("/todo/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        return todoService.deleteTodoById(id);
    }

}
```