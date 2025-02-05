package stud.ntnu.no.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRegister {
  private final List<User> users;
  private int userIdNumber = 0;

  public UserRegister(){
    users = new ArrayList<>();
  }

  public void addNewUser(User user) {
    user.setId(userIdNumber++);
    users.add(user);
  }

  public User getUserByIndex(int index) {
    return users.get(index);
  }

  public void setNewUserData(User oldUser, User newUser) {
    users.remove(oldUser);
    addNewUser(newUser);
  }

  /**
   * deletes user with the given id
   *
   * @param id the id of the user wanted to be deleted
   * @return returns an empty optional if the user was not found, an optional with the deleted user is return if the user was found
   */
  public Optional<User> deleteUserById(int id) {
    Optional<User> optionalUser = getUserFromId(id);
    if (!optionalUser.isEmpty()) {
      users.remove(optionalUser.get());
    }
    return optionalUser;
  }

  public Optional<User> getUserFromId(int id) {
    Optional<User> optionalUser = Optional.empty();
    for (User user : users) {
      if (user.getId() == id) {
        optionalUser = Optional.of(user);
      }
    }

    return optionalUser;
  }

  public List<User> getUsers() {
    return users;
  }

  public int getSize() {
    return users.size();
  }
}
