package com.example.esercizioDependencyInjection.service;

import com.example.esercizioDependencyInjection.component.MyComponent;
import com.example.esercizioDependencyInjection.utils.Print;
import org.springframework.stereotype.Service;

import static com.example.esercizioDependencyInjection.utils.Print.constuctorCall;

@Service
public class MyService {

    private MyComponent myComponent;

    private MyService(MyComponent myComponent){
        constuctorCall("MyService");
        this.myComponent = myComponent;
    }

    public String getName(){
        Print.printCall("getMyComponent");
        return myComponent.getMyComponentName();
    }
}
