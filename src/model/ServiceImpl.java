package model;

import repository.UserRepository;

import java.util.List;

public class ServiceImpl implements Iservice{
    @Override
    public List<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    @Override
    public User insertUser(User user) {
        return UserRepository.insertUser(user);
    }

    @Override
    public Integer deleteById(Integer id) {
        return  UserRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        return UserRepository.updateUser(id,user);

    }
}
