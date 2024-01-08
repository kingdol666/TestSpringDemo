package com.kingdol.testspringdemo1.service;


import com.kingdol.testspringdemo1.entity.UserEntity;
import com.kingdol.testspringdemo1.repository.MyRepository;
import com.kingdol.testspringdemo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private MyRepository myRepository;

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserEntity> getUserByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public String saveUser(UserEntity user) {
        userRepository.save(user);
        return "User saved successfully";
    }

    // 其他服务方法...
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public UserEntity verifyUser(String username, String password) {
        return userRepository.verifyUser(username, password);
    }

    public String updateUser(UserEntity user) {
        userRepository.save(user);
        return "User updated successfully";
    }

    // 其他服务方法...
    public UserEntity getUserById(Long id) {
        UserEntity UserId = userRepository.findById(id).get();
        return UserId;
    }

    public List<UserEntity> getAllUserss() {
        String sql = "select * from users";
        List<Object[]> objects = myRepository.executeNativeQuery(sql);
        List<UserEntity> users = new ArrayList<>();
        for (Object[] object : objects) {
            UserEntity user = new UserEntity();
            user.setId((Long) object[0]);
            user.setUsername((String) object[1]);
            user.setPassword((String) object[2]);
            users.add(user);
        }
        return users;
    }
}