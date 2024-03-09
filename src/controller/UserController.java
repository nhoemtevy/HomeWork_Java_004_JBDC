package controller;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserController {
    public static List<User> getAllUsers(){
        return UserRepository.getAllUsers();
    }
    public static void updateUser(User user) {
       UserRepository.updateUser(user);
    }

    public static int deleteUserByID(Integer id) {
      return    UserRepository.deleteById(id);

    }
public static void insertUser(User user){
    UserRepository.insertUser(user);
}

}

