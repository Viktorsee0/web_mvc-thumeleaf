package com.calc.dao;

import com.calc.model.Operation;
import com.calc.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationDao {
    private List<Operation> operations = new ArrayList<>();

    public void save(Operation operation){
        operations.add(operation);
    }

    public List<Operation> get(){
        return operations;
    }

    public List<Operation> getByUser(User user){
        return operations.stream().filter(us -> us.getUser().equals(user)).collect(Collectors.toList());
    }
}
