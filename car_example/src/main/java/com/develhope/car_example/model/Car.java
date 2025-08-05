package com.develhope.car_example.model;

import com.develhope.car_example.enums.CarType;
import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelnName;

    public Car(String modelnName, CarType type) {
        this.modelnName = modelnName;
        this.type = type;
    }

    public Car(){}

    @Enumerated(value = EnumType.STRING)
    private CarType type;

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getModelnName() {
        return modelnName;
    }

    public void setModelnName(String modelnName) {
        this.modelnName = modelnName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
