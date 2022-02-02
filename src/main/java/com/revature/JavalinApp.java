package com.revature;

import com.revature.controller.UserController;
import com.revature.util.LogginUtil;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
public class JavalinApp {

    private UserController userController = new UserController();
    private LogginUtil loggingUtil = new LogginUtil();
    //private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();
    //private AuthController authController = new AuthController();

    private Javalin app = Javalin.create().routes(()->{
        path("user",()->{
            path("{id}",()->{
                get(userController::handleGetOne);
                put(userController::handleUpdate);
            });
        });
    });

    public void start(int port){
        app.start(port);
    }
}
