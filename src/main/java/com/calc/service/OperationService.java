package com.calc.service;


import com.calc.dao.OperationDao;
import com.calc.model.Operation;
import com.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    @Autowired
    private OperationDao dao;

    public void save(Operation operation){
        dao.save(operation);
    }

    public List<Operation> get(){
        return dao.get();
    }
    public List<Operation> getByUser(User user){
        return dao.getByUser(user);
    }
}
