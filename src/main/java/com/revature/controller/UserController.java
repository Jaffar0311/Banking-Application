package com.revature.controller;


import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.services.userServices;
import io.javalin.http.Context;

public class UserController {

    private userServices userservice = new userServices();

    public void handleGetOne(Context ctx){
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userservice.getById(id);
        ctx.json(user);
    }

    public void handleUpdate(Context context) {
        User user = context.bodyAsClass(User.class);
        user.setUserId(Integer.parseInt(context.pathParam("id")));

        if(userservice.update(user)) {
            context.status(200);
        } else {
            context.status(400);
        }
    }



}
