package com.calc.service;


import com.calc.dao.UserDao;
import com.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserDao dao;

    public void save(User user){
        dao.save(user);
    }

    public List<User> get(){
        return dao.get();
    }

    public User getByLogin(User user){
        return dao.getByLogin(user);
    }
}
