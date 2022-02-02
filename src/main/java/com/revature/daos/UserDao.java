package com.revature.daos;

import com.revature.models.User;

public interface UserDao {
    public boolean createUser(User user);
    public User getUserById(int id);
    public boolean update(User user);
    public User getByEmailAndPassword(String email, String password);
}
