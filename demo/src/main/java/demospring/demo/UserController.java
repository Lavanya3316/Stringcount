package demospring.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UsersService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable int id) {

        Optional<User> target = userService.getUserById(id);
        if(target == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Resource not available here");
        }
        return target;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }


    @PutMapping("/users/{id}")
    public User createUser(@RequestBody User newUser, @PathVariable int id) {
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}

