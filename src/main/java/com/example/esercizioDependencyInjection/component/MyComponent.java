package com.example.esercizioDependencyInjection.component;

import org.springframework.stereotype.Component;

import static com.example.esercizioDependencyInjection.utils.Print.constuctorCall;

@Component
public class MyComponent {

    private String myComponentName;

    private MyComponent(){
        this.myComponentName = "name";
        constuctorCall("MyComponent");
    }

    public String getMyComponentName() {
        return myComponentName;
    }
}
