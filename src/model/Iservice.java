package model;

import java.util.List;

public interface Iservice {
    // get all user
    List<User> getAllUsers();
    // insert user
    User insertUser(User user);
    // delete user by id
    Integer deleteById (Integer id);
    // update user by id
    User updateUser(int id, User user);
}
