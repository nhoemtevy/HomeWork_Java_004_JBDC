package controller;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserController {
    public static List<User> getAllUsers(){
        return UserRepository.getAllUsers();
    }
//    public static User updateUser(User user) {
//        return UserRepository.updateUser(user);
//    }
//
//    public static void deleteById(Integer id) {
//        UserRepository.deleteById(id);
//    }
//
//    public static User insertUser(User user) {
//        return UserRepository.insertUser(user);
//    }
public static void insertUser(User user){
    UserRepository.insertUser(user);
}
    public void deleteById(Integer id) {
        UserRepository.deleteById(id);
    }
    public void updateByUser (User user){
        UserRepository.updateUser(user);
    }
}

