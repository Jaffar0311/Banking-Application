package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.models.UserType;

public class MyBank {
    private UserDao userDao = new UserDaoImpl();

    public boolean createUser(){

        User user = new User(UserType.CUSTOMER,"John","Doe","john@gmail.com","pass");
        return userDao.createUser(user);
    }
}
