package com.example.esercizioDependencyInjection.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Print {

    static Logger logger = LoggerFactory.getLogger(Print.class);

    public static void printCall(String method){
       logger.info("{} has been called.", method);
    }

    public static void constuctorCall(String constr){
        logger.info("{}'s constructor", constr);
    }
}
