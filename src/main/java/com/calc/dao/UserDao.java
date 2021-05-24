package com.calc.dao;

import com.calc.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private List<User> users = new ArrayList<>();
    private static int incId = 1;

    public void save(User user){
        user.setId(incId++);
        users.add(user);
    }

    public List<User> get(){

        return users;
    }

    public User getByLogin(User cUser){
        for (User user : users){
            if (user.getLogin().equals(cUser.getLogin()) &&
                user.getPassword().equals(cUser.getPassword())){
                return user;
            }
        }
        return null;
    }
}
