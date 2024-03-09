package controller;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserController {
    public List<User> getAllUsers(){
        return UserRepository.getAllUsers();
    }
    public  User updateUser(int id, User user) {
       return UserRepository.updateUser(id,user);
    }

    public  int deleteUserByID(Integer id) {
      return    UserRepository.deleteById(id);

    }
public  User insertUser(User user) {
    return UserRepository.insertUser(user);
}
}

