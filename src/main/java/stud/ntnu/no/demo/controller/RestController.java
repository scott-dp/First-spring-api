package stud.ntnu.no.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stud.ntnu.no.demo.model.User;
import stud.ntnu.no.demo.model.UserRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
  UserRegister users = new UserRegister();

  @PutMapping("/users/{id}")
  public ResponseEntity<User> changeUserData(@RequestBody User newUserObject, @PathVariable int id) {
    Optional<User> optionalUser = users.getUserFromId(id);
    if (optionalUser.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    users.setNewUserData(optionalUser.get(), newUserObject);
    return ResponseEntity.ok(newUserObject);
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return users.getUsers();
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User user) { //Spør om body i http posten
    users.addNewUser(user);
    return user;
  }
}
