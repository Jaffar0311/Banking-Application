package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class userServices {

    private UserDao userDao = new UserDaoImpl();

    public User getById(int id){
        return userDao.getUserById(id);
    }
    public boolean update(User user) {
        return userDao.update(user);
    }
}
