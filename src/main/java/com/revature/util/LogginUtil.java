package com.revature.util;

import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogginUtil {
    private static Logger logger = LoggerFactory.getLogger(LogginUtil.class);

    public void logRequest(Context ctx){
        logger.info(ctx.method() +" request made to: "+ctx.path());
    }
}
