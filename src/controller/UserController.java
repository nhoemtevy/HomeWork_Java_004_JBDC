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

    public static User deleteById(Integer id) {
       UserRepository.deleteById(id);
        return null;
    }
public static void insertUser(User user){
    UserRepository.insertUser(user);
}

}

