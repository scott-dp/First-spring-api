package stud.ntnu.no.demo.model;

import java.util.ArrayList;
import java.util.List;

public class User {
  private List<String> hobbies = new ArrayList<>();
  private String firstName;
  private String lastName;
  private int age; //Rather get birthdate instead, this is only for demo
  private int id;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public List<String> getHobbies() {
    return hobbies;
  }

  public void addHobby(String hobby) {
    this.hobbies.add(hobby);
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age < 1) {
      throw new IllegalArgumentException("Age cant be less than 1");
    }
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
