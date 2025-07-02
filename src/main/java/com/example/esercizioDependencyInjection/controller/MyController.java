package com.example.esercizioDependencyInjection.controller;

import com.example.esercizioDependencyInjection.service.MyService;
import com.example.esercizioDependencyInjection.utils.Print;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.esercizioDependencyInjection.utils.Print.constuctorCall;

@RestController
@RequestMapping("/home")
public class MyController {

    private MyService myService;

    private MyController(MyService myService){
        constuctorCall("MyController");
        this.myService = myService;
    }

    @GetMapping("/getName")
    public String getName(){
        Print.printCall("getName");
        return myService.getName();
    }

    @GetMapping
    public String welcome(){
        return "Welcome home!";
    }
}
